import java.util.Scanner;

public class Level1 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		setMap();
	}

	private static void setMap() {
		System.out.println("Enter the Map Size");
		int mapSize = scanner.nextInt();
		char[][] board = new char[mapSize][mapSize];
		setBoard(board);
		printBoard(board);
		getInput(board);
	}

	private static void getInput(char[][] board) {
		boolean boolValue = true;
		boolean boolValue1 = true;
		boolean boolValue2 = true;
		boolean boolValue3 = true;
		while (boolValue) {
			System.out.println("Enter the User Position");
			String userPos = scanner.next();
			if (setPosition(userPos, board, 'P')) {
				boolValue = false;
				printBoard(board);
				while (boolValue1) {
					System.out.println("Enter the Key Position");
					String keyPos = scanner.next();
					if (setPosition(keyPos, board, 'K')) {
						boolValue1 = false;
						printBoard(board);
						while (boolValue2) {
							System.out.println("Enter the Villian Count");
							int villianCount = scanner.nextInt();
							for (int i = 0; i < villianCount; i++) {
								System.out.println("Enter Villian" + (i + 1) + " Position");
								String villianPos = scanner.next();
								if (setPosition(villianPos, board, 'V')) {
									printBoard(board);
									boolValue2 = false;
								}
							}
						}
						while (boolValue3) {
							System.out.println("Enter the Brick Count");
							int brickCount = scanner.nextInt();
							for (int i = 0; i < brickCount; i++) {
								System.out.println("Enter Brick" + (i + 1) + " Position");
								String brickPos = scanner.next();
								if (setPosition(brickPos, board, 'B')) {
									printBoard(board);
									boolValue3 = false;
								}
							}
						}
					}
				}
			}
			setMoves(board);
		}
	}

	private static void setMoves(char[][] board) {
		System.out.println("enter the move");
		String moves = scanner.next();
		for(int i =0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(board[i][j]=='P') {
					moves(board,i,j,moves);
					printBoard(board);
					
				}
				
			}
		}
//		boolean bool = true;
//		while(bool) {
//		System.out.println("1: Plant\n2: detonate\n3: move");
//		int option = scanner.nextInt();
//		if(option==1) {
//			plantBomb(board);
//			printBoard(board);
//		}else if(option==2){
//			detonate(board);
//			printBoard(board);
//		}else {
//			setMoves(board);
//			bool=false;
//		}
//		}
	}

	private static void detonate(char[][] board) {
		for(int i =0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(board[i][j]=='X') {
					if(board[i-1][j]=='B' && board[i-1][j]!='P') {
						board[i-1][j]=' ';
					}
					if(board[i+1][j]=='B' && board[i+1][j]!='P') {
						board[i+1][j]=' ';
					}
					if(board[i][j-1]=='B' && board[i+1][j]!='P') {
						board[i][j-1]=' ';
					}
					if(board[i][j+1]=='B' && board[i][j+1]!='P') {
						board[i][j+1]=' ';
					}
					if(board[i-1][j]=='P' || board[i+1][j]=='P' || board[i+1][j]=='P' ||board[i][j+1]=='P') {
						System.out.println("Player dies");
						System.exit(0);
					}
					break;
				}	
			}
		}
	}

	private static void plantBomb(char[][] board) {
		for(int i =0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(board[i][j]=='P') {
					board[i][j]='X';
					System.out.println("Enter the Move");
					String moves = scanner.next();
					moves(board,i,j,moves);
					printBoard(board);
					break;
				}
			}
		}
	}

	private static void moves(char[][] board, int i, int j, String moves) {
		if(moves.charAt(0)=='W') {
			if(board[i-1][j]=='\0') {
				board[i-1][j]='P';
				board[i][j]=' ';
			}else if(board[i-1][j]=='V'){
				System.out.println("Player Dies");
				System.exit(0);
			}else if(board[i-1][j]=='K') {
				System.out.println("Player Wins");
				System.exit(0);
			}
		}else if(moves.charAt(0)=='S') {
			if(board[i+1][j]=='\0') {
				board[i+1][j]='P';
				board[i][j]=' ';
			}else if(board[i+1][j]=='V'){
				System.out.println("Player Dies");
				System.exit(0);
			}else if(board[i+1][j]=='K') {
				System.out.println("Player Wins");
				System.exit(0);
			}
		}else if(moves.charAt(0)=='A') {
			if(board[i][j-1]=='\0') {
				board[i][j-1]='P';
				board[i][j]=' ';
			}else if(board[i][j-1]=='V'){
				System.out.println("Player Dies");
				System.exit(0);
			}else if(board[i][j-1]=='K') {
				System.out.println("Player Wins");
				System.exit(0);
			}
		}else if(moves.charAt(0)=='D') {
			if(board[i][j+1]=='\0') {
				board[i][j+1]='P';
				board[i][j]=' ';
			}else if(board[i][j+1]=='V'){
				System.out.println("Player Dies");
				System.exit(0);
			}else if(board[i][j+1]=='K') {
				System.out.println("Player Wins");
				System.exit(0);
			}
		}else if(moves.charAt(0)=='Q') {
			if(board[i-1][j-1]=='\0') {
				board[i-1][j-1]='P';
				board[i][j]=' ';
			}else if(board[i-1][j-1]=='V'){
				System.out.println("Player Dies");
				System.exit(0);
			}else if(board[i-1][j-1]=='K') {
				System.out.println("Player Wins");
				System.exit(0);
			}
		}else if(moves.charAt(0)=='E') {
			if(board[i-1][j+1]=='\0') {
				board[i-1][j+1]='P';
				board[i][j]=' ';
			}else if(board[i-1][j+1]=='V'){
				System.out.println("Player Dies");
				System.exit(0);
			}else if(board[i-1][j+1]=='K') {
				System.out.println("Player Wins");
				System.exit(0);
			}
		}else if(moves.charAt(0)=='Z') {
			if(board[i+1][j-1]=='\0') {
				board[i+1][j-1]='P';
				board[i][j]=' ';
			}else if(board[i+1][j-1]=='V'){
				System.out.println("Player Dies");
				System.exit(0);
			}else if(board[i+1][j-1]=='K') {
				System.out.println("Player Wins");
				System.exit(0);
			}
		}else if(moves.charAt(0)=='C') {
			if(board[i+1][j+1]=='\0') {
				board[i+1][j+1]='P';
				board[i][j]=' ';
			}else if(board[i+1][j+1]=='V'){
				System.out.println("Player Dies");
				System.exit(0);
			}else if(board[i+1][j+1]=='K') {
				System.out.println("Player Wins");
				System.exit(0);
			}
		}
	}

	private static boolean setPosition(String position, char[][] board, char place) {
		int row = position.charAt(0) - 64;
		int col = position.charAt(1) - 64;
		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
			System.out.println("Out of Map Size");
			return false;
		}
		if (board[row][col] == '\0') {
			board[row][col] = place;
			return true;
		} else {
			System.out.println("Element is already present");
			return false;
		}
	}

	private static void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void setBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (i == 0 && i != j) {
					board[i][j] = (char) ('A' + j - 1);
				} else if (j == 0 && i != j) {
					board[i][j] = (char) ('A' + i - 1);
				} else if (i == 1 || i == board.length - 1 || j == 1 || j == board[0].length - 1 && j != 0) {
					board[i][j] = '*';
				} else if (i % 2 != 0 && j % 2 != 0) {
					board[i][j] = '*';
				}
			}
		}
	}
}
