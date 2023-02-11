import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BomberManGame {
	Scanner scanner = new Scanner(System.in);
	char[][] board;
	int[] playerPosition = new int[2];
	int[] keyPosition = new int[2];
	int range = 1;
	boolean diagonal = false;
	boolean bombPlanted = false;
	int bombCapacity = 1;
	Queue<ArrayList<Integer>> bombPosition = new LinkedList<>();

	public static void main(String[] args) {
		BomberManGame bomberMan = new BomberManGame();
		bomberMan.setMap();
	}

	private void setMap() {
		System.out.println("Enter the Map Size");
		int mapSize = scanner.nextInt();
		board = new char[mapSize][mapSize];
		setBoard(board);
		printBoard(board);
		getInput(board);
		gameStarts(board);
	}

	private void gameStarts(char[][] board) {
		while (move(board)) {
			printBoard(board);
			if (playerPosition[0] == keyPosition[0] && playerPosition[1] == keyPosition[1]) {
				System.out.println("<< Player won the game >>");
				break;
			}
		}
	}

	public boolean move(char[][] board) {
		int n = board.length;
		int row = playerPosition[0];
		int col = playerPosition[1];
		System.out.println("Enter the moves: ");
		char dir = scanner.next().charAt(0);
		switch (dir) {
		case 'W': // move up
			if (row > 2 && board[row - 1][col] != 'B') {
				if (board[row - 1][col] == 'V') {
					System.out.println("Player died.");
					return false;
				} else if (board[row - 1][col] == '\0' && board[row][col] == 'X') {
					playerPosition[0] = row - 1;
					board[row][col] = 'X';
					board[playerPosition[0]][col] = 'P';
				} else if (board[row - 1][col] == '\0') {
					playerPosition[0] = row - 1;
					board[row][col] = '\0';
					board[playerPosition[0]][col] = 'P';
				} else if (board[row - 1][col] == '1' || board[row - 1][col] == '2' || board[row - 1][col] == '3') {
					playerPosition[0] = row - 1;
					board[row][col] = '\0';
					char temp = board[row - 1][col];
					board[playerPosition[0]][col] = 'P';
					if (temp == '1') {
						range = 2;
					} else if (temp == '2') {
						diagonal = true;
					} else if (temp == '3') {
						bombCapacity = 2;
					}
				} else if (board[row - 1][col] == 'K') {
					System.out.println("Player wins.");
					System.exit(0);
				}
			} else {
				System.out.println("Invalid Move");
			}
			break;
		case 'S': // move down
			if (row < n - 2 && board[row + 1][col] != 'B') {
				if (board[row + 1][col] == 'V') {
					System.out.println("Player died.");
					return false;
				} else if (board[row + 1][col] == '\0' && board[row][col] == 'X') {
					playerPosition[0] = row + 1;
					board[row][col] = 'X';
					board[playerPosition[0]][col] = 'P';
				} else if (board[row + 1][col] == '\0') {
					playerPosition[0] = row + 1;
					board[row][col] = '\0';
					board[playerPosition[0]][col] = 'P';
				} else if (board[row + 1][col] == 'K') {
					System.out.println("Player wins.");
					System.exit(0);
				} else if (board[row + 1][col] == '1' || board[row + 1][col] == '2' || board[row + 1][col] == '3') {
					playerPosition[0] = row + 1;
					board[row][col] = '\0';
					char temp = board[row + 1][col];
					board[playerPosition[0]][col] = 'P';
					if (temp == '1') {
						range = 2;
					} else if (temp == '2') {
						diagonal = true;
					} else if (temp == '3') {
						bombCapacity = 2;
					}
				}
			} else {
				System.out.println("Invalid Move");
			}
			break;
		case 'A': // move left
			if (col > 2 && board[row][col - 1] != 'B') {
				if (board[row][col - 1] == 'V') {
					System.out.println("Player died.");
					return false;
				} else if (board[row][col - 1] == '\0' && board[row][col] == 'X') {
					playerPosition[1] = col - 1;
					board[row][col] = 'X';
					board[row][playerPosition[1]] = 'P';
				} else if (board[row][col - 1] == '\0') {
					playerPosition[1] = col - 1;
					board[row][col] = '\0';
					board[row][playerPosition[1]] = 'P';
				} else if (board[row][col - 1] == 'K') {
					System.out.println("Player wins.");
					System.exit(0);
				} else if (board[row][col - 1] == '1' || board[row][col - 1] == '2' || board[row][col - 1] == '3') {
					playerPosition[1] = col - 1;
					board[row][col] = '\0';
					char temp = board[row][col - 1];
					board[row][playerPosition[1]] = 'P';
					if (temp == '1') {
						range = 2;
					} else if (temp == '2') {
						diagonal = true;
					} else if (temp == '3') {
						bombCapacity = 2;
					}
				}
			} else {
				System.out.println("Invalid Move");
			}
			break;
		case 'D': // move right
			if (col < n - 2 && board[row][col + 1] != 'B') {
				if (board[row][col + 1] == 'V') {
					System.out.println("Player died.");
					return false;
				} else if (board[row][col + 1] == '\0' && board[row][col] == 'X') {
					playerPosition[1] = col + 1;
					board[row][col] = 'X';
					board[row][playerPosition[1]] = 'P';
				} else if (board[row][col + 1] == '\0') {
					playerPosition[1] = col + 1;
					board[row][col] = '\0';
					board[row][playerPosition[1]] = 'P';
				} else if (board[row][col + 1] == 'K') {
					System.out.println("Player wins.");
					System.exit(0);
				} else if (board[row][col + 1] == '1' || board[row][col + 1] == '2' || board[row][col + 1] == '3') {
					playerPosition[1] = col + 1;
					board[row][col] = '\0';
					char temp = board[row][col + 1];
					board[row][playerPosition[1]] = 'P';
					if (temp == '1') {
						range = 2;
					} else if (temp == '2') {
						diagonal = true;
					} else if (temp == '3') {
						bombCapacity = 2;
					}
				}
			} else {
				System.out.println("Invalid Move");
			}
			break;
		case 'Q': // move up left diagonal
			if (row > 2 && col > 2 && board[row - 1][col - 1] != 'B') {
				if (board[row - 1][col - 1] == 'V') {
					System.out.println("Player died.");
					return false;
				} else if (board[row - 1][col - 1] == '\0' && board[row][col] == 'X') {
					playerPosition[0] = row - 1;
					playerPosition[1] = col - 1;
					board[row][col] = 'X';
					board[playerPosition[0]][playerPosition[1]] = 'P';
				} else if (board[row - 1][col - 1] == '\0') {
					playerPosition[0] = row - 1;
					playerPosition[1] = col - 1;
					board[row][col] = '\0';
					board[playerPosition[0]][playerPosition[1]] = 'P';
				} else if (board[row - 1][col - 1] == 'K') {
					System.out.println("Player wins.");
					System.exit(0);
				} else if (board[row - 1][col - 1] == '1' || board[row - 1][col - 1] == '2'
						|| board[row - 1][col - 1] == '3') {
					playerPosition[0] = row - 1;
					playerPosition[1] = col - 1;
					board[row][col] = '\0';
					char temp = board[row - 1][col - 1];
					board[playerPosition[0]][playerPosition[1]] = 'P';
					if (temp == '1') {
						range = 2;
					} else if (temp == '2') {
						diagonal = true;
					} else if (temp == '3') {
						bombCapacity = 2;
					}
				}
			} else {
				System.out.println("Invalid Move");
			}
			break;
		case 'Z': // move down left diagonal
			if (row < n - 2 && col > 2 && board[row + 1][col - 1] != 'B') {
				if (board[row + 1][col - 1] == 'V') {
					System.out.println("Player died.");
					return false;
				} else if (board[row + 1][col - 1] == '\0' && board[row][col] == 'X') {
					playerPosition[0] = row + 1;
					playerPosition[1] = col - 1;
					board[row][col] = 'X';
					board[playerPosition[0]][playerPosition[1]] = 'P';
				} else if (board[row + 1][col - 1] == '\0') {
					playerPosition[0] = row + 1;
					playerPosition[1] = col - 1;
					board[row][col] = '\0';
					board[playerPosition[0]][playerPosition[1]] = 'P';
				} else if (board[row + 1][col - 1] == 'K') {
					System.out.println("Player wins.");
					System.exit(0);
				} else if (board[row + 1][col - 1] == '1' || board[row + 1][col - 1] == '2'
						|| board[row + 1][col - 1] == '3') {
					playerPosition[0] = row + 1;
					playerPosition[1] = col - 1;
					board[row][col] = '\0';
					char temp = board[row + 1][col - 1];
					board[playerPosition[0]][playerPosition[1]] = 'P';
					if (temp == '1') {
						range = 2;
					} else if (temp == '2') {
						diagonal = true;
					} else if (temp == '3') {
						bombCapacity = 2;
					}
				}
			} else {
				System.out.println("Invalid Move");
			}
			break;
		case 'E': // move up right diagonal
			if (row > 2 && col < n - 2 && board[row - 1][col + 1] != 'B') {
				if (board[row - 1][col + 1] == 'V') {
					System.out.println("Player died.");
					return false;
				} else if (board[row - 1][col + 1] == '\0' && board[row][col] == 'X') {
					playerPosition[0] = row - 1;
					playerPosition[1] = col + 1;
					board[row][col] = 'X';
					board[playerPosition[0]][playerPosition[1]] = 'P';
				} else if (board[row - 1][col + 1] == '\0') {
					playerPosition[0] = row - 1;
					playerPosition[1] = col + 1;
					board[row][col] = '\0';
					board[playerPosition[0]][playerPosition[1]] = 'P';
				} else if (board[row - 1][col + 1] == 'K') {
					System.out.println("Player wins.");
					System.exit(0);
				} else if (board[row - 1][col + 1] == '1' || board[row - 1][col + 1] == '2'
						|| board[row - 1][col + 1] == '3') {
					playerPosition[0] = row - 1;
					playerPosition[1] = col + 1;
					board[row][col] = '\0';
					char temp = board[row - 1][col + 1];
					board[playerPosition[0]][playerPosition[1]] = 'P';
					if (temp == '1') {
						range = 2;
					} else if (temp == '2') {
						diagonal = true;
					} else if (temp == '3') {
						bombCapacity = 2;
					}
				}
			} else {
				System.out.println("Invalid Move");
			}
			break;
		case 'C': // move down right diagonal
			if (row < n - 2 && col < n - 2 && board[row + 1][col + 1] != 'B') {
				if (board[row + 1][col + 1] == 'V') {
					System.out.println("Player died.");
					return false;
				} else if (board[row + 1][col + 1] == '\0' && board[row][col] == 'X') {
					playerPosition[0] = row + 1;
					playerPosition[1] = col + 1;
					board[row][col] = 'X';
					board[playerPosition[0]][playerPosition[1]] = 'P';
				} else if (board[row + 1][col + 1] == '\0') {
					playerPosition[0] = row + 1;
					playerPosition[1] = col + 1;
					board[row][col] = '\0';
					board[playerPosition[0]][playerPosition[1]] = 'P';
				} else if (board[row + 1][col + 1] == 'K') {
					System.out.println("Player wins.");
					System.exit(0);
				} else if (board[row + 1][col + 1] == '1' || board[row + 1][col + 1] == '2'
						|| board[row + 1][col + 1] == '3') {
					playerPosition[0] = row + 1;
					playerPosition[1] = col + 1;
					board[row][col] = '\0';
					char temp = board[row + 1][col + 1];
					board[playerPosition[0]][playerPosition[1]] = 'P';
					if (temp == '1') {
						range = 2;
					} else if (temp == '2') {
						diagonal = true;
					} else if (temp == '3') {
						bombCapacity = 2;
					}
				}
			} else {
				System.out.println("Invalid Move");
			}
			break;
		case 'X':
			setBomb(board, row, col);
			break;
		default:
			System.out.println("Invalid Input");
		}
		return true;
	}

	public void setBomb(char[][] board, int row, int col) {
		System.out.println("1. plant.");
		System.out.println("2. Detonate.");
		int choose = scanner.nextInt();

		switch (choose) {
		case 1:
			if (bombCapacity > bombPosition.size() && !bombPlanted) {
				ArrayList<Integer> position = new ArrayList<>();
				position.add(row);
				position.add(col);
				board[row][col] = 'X';
				bombPosition.add(position);
				bombPlanted = false;
			}
			break;
		case 2:
			if (bombPosition.isEmpty()) {
				System.out.println("No bomb is planted to detonate");
				break;
			}

			while (!bombPosition.isEmpty()) {
				ArrayList<Integer> position = bombPosition.poll();
				int r = 1;
				while (r <= range) {
					// down
					if (board[position.get(0) + r][position.get(1)] == 'P') {
						System.out.println("Player died.");
						System.exit(0);
					}
					if (board[position.get(0) + r][position.get(1)] == 'V'
							&& board[position.get(0) + r - 1][position.get(1)] != '*'
							|| board[position.get(0) + r][position.get(1)] == 'B'
									&& board[position.get(0) + r - 1][position.get(1)] != '*'
							|| board[position.get(0) + r][position.get(1)] == '\0') {
						board[position.get(0) + r][position.get(1)] = '\0';
						board[position.get(0)][position.get(1)] = '\0';
					}
					if (board[position.get(0) + r][position.get(1)] == 'M') {
						int currRow = position.get(0) + r;
						int currCol = position.get(1);
						dynamiteBomb(board, currRow, currCol);
					}

					// up
					if (board[position.get(0) - r][position.get(1)] == 'P') {
						System.out.println("Player died.");
						System.exit(0);
					}
					if (board[position.get(0) - r][position.get(1)] == 'V'
							&& board[position.get(0) - r + 1][position.get(1)] != '*'
							|| board[position.get(0) - r][position.get(1)] == 'B'
									&& board[position.get(0) - r + 1][position.get(1)] != '*'
							|| board[position.get(0) - r][position.get(1)] == '\0') {
						board[position.get(0) - r][position.get(1)] = '\0';
						board[position.get(0)][position.get(1)] = '\0';
					}
					if (board[position.get(0) - r][position.get(1)] == 'M') {
						int currRow = position.get(0) - r;
						int currCol = position.get(1);
						dynamiteBomb(board, currRow, currCol);
					}

					// left
					if (board[position.get(0)][position.get(1) - r] == 'P') {
						System.out.println("Player died.");
						System.exit(0);
					}
					if (board[position.get(0)][position.get(1) - r] == 'V'
							&& board[position.get(0)][position.get(1) - r + 1] != '*'
							|| board[position.get(0)][position.get(1) - r] == 'B'
									&& board[position.get(0)][position.get(1) - r + 1] != '*'
							|| board[position.get(0)][position.get(1) - r] == '\0') {
						board[position.get(0)][position.get(1) - r] = '\0';
						board[position.get(0)][position.get(1)] = '\0';
					}
					if (board[position.get(0)][position.get(1) - r] == 'M') {
						int currRow = position.get(0);
						int currCol = position.get(1) - r;
						dynamiteBomb(board, currRow, currCol);
					}

					// right
					if (board[position.get(0)][position.get(1) + r] == 'P') {
						System.out.println("Player died.");
						System.exit(0);
					}
					if (board[position.get(0)][position.get(1) + r] == 'V'
							&& board[position.get(0)][position.get(1) + r - 1] != '*'
							|| board[position.get(0)][position.get(1) + r] == 'B'
									&& board[position.get(0)][position.get(1) + r - 1] != '*'
							|| board[position.get(0)][position.get(1) + r] == '\0') {
						board[position.get(0)][position.get(1) + r] = '\0';
						board[position.get(0)][position.get(1)] = '\0';
					}
					if (board[position.get(0)][position.get(1) + r] == 'M') {
						int currRow = position.get(0);
						int currCol = position.get(1) + r;
						dynamiteBomb(board, currRow, currCol);
					}

					if (diagonal) {

						// move up left diagonal
						if (board[position.get(0) - r][position.get(1) - r] == 'P') {
							System.out.println("Player died.");
							System.exit(0);
						}
						if (board[position.get(0) - r][position.get(1) - r] == 'V'
								&& board[position.get(0) - r + 1][position.get(1) - r + 1] != '*'
								|| board[position.get(0) - r][position.get(1) - r] == 'B'
										&& board[position.get(0) - r + 1][position.get(1) - r + 1] != '*'
								|| board[position.get(0) - r][position.get(1) - r] == '\0') {
							board[position.get(0) - r][position.get(1) - r] = '\0';
							board[position.get(0)][position.get(1)] = '\0';
						}
						if (board[position.get(0) - r][position.get(1) - r] == 'M') {
							int currRow = position.get(0) - r;
							int currCol = position.get(1) - r;
							dynamiteBomb(board, currRow, currCol);
						}

						// move down left diagonal
						if (board[position.get(0) + r][position.get(1) - r] == 'P') {
							System.out.println("Player died.");
							System.exit(0);
						}
						if (board[position.get(0) + r][position.get(1) - r] == 'V'
								&& board[position.get(0) + r - 1][position.get(1) - r + 1] != '*'
								|| board[position.get(0) + r][position.get(1) - r] == 'B'
										&& board[position.get(0) + r - 1][position.get(1) - r + 1] != '*'
								|| board[position.get(0) + r][position.get(1) - r] == '\0') {
							board[position.get(0) + r][position.get(1) - r] = '\0';
							board[position.get(0)][position.get(1)] = '\0';
						}
						if (board[position.get(0) + r][position.get(1) - r] == 'M') {
							int currRow = position.get(0) + r;
							int currCol = position.get(1) - r;
							dynamiteBomb(board, currRow, currCol);
						}

						// move up right diagonal
						if (board[position.get(0) - r][position.get(1) + r] == 'P') {
							System.out.println("Player died.");
							System.exit(0);
						}
						if (board[position.get(0) - r][position.get(1) + r] == 'V'
								&& board[position.get(0) - r + 1][position.get(1) + r - 1] != '*'
								|| board[position.get(0) - r][position.get(1) + r] == 'B'
										&& board[position.get(0) - r + 1][position.get(1) + r - 1] != '*'
								|| board[position.get(0) - r][position.get(1) + r] == '\0') {
							board[position.get(0) - r][position.get(1) + r] = '\0';
							board[position.get(0)][position.get(1)] = '\0';
						}
						if (board[position.get(0) - r][position.get(1) + r] == 'M') {
							int currRow = position.get(0) - r;
							int currCol = position.get(1) + r;
							dynamiteBomb(board, currRow, currCol);
						}

						// move down right diagonal
						if (board[position.get(0) + r][position.get(1) + r] == 'P') {
							System.out.println("Player died.");
							System.exit(0);
						}
						if (board[position.get(0) + r][position.get(1) + r] == 'V'
								&& board[position.get(0) + r - 1][position.get(1) + r - 1] != '*'
								|| board[position.get(0) + r][position.get(1) + r] == 'B'
										&& board[position.get(0) + r - 1][position.get(1) + r - 1] != '*'
								|| board[position.get(0) + r][position.get(1) + r] == '\0') {
							board[position.get(0) + r][position.get(1) + r] = '\0';
							board[position.get(0)][position.get(1)] = '\0';
						}
						if (board[position.get(0) + r][position.get(1) + r] == 'M') {
							int currRow = position.get(0) + r;
							int currCol = position.get(1) + r;
							dynamiteBomb(board, currRow, currCol);
						}
						diagonal = false;
					}
					r++;
				}
			}

		}
	}

	private void dynamiteBomb(char[][] board, int currRow, int currCol) {
		int r = 1;
		while (r <= 1) {
			// down
			if (board[currRow + r][currCol] == 'P') {
				System.out.println("Player died.");
				System.exit(0);
			}
			if (board[currRow + r][currCol] == 'V' || board[currRow + r][currCol] == 'B'
					|| board[currRow + r][currCol] == '\0') {
				board[currRow + r][currCol] = '\0';
				board[currRow][currCol] = '\0';
			}
			if (board[currRow + r][currCol] == 'M') {
				int curRow = currRow + r;
				int curCol = currCol;
				dynamiteBomb(board, curRow, curCol);
			}

			// up
			if (board[currRow - r][currCol] == 'P') {
				System.out.println("Player died.");
				System.exit(0);
			}
			if (board[currRow - r][currCol] == 'V' || board[currRow - r][currCol] == 'B'
					|| board[currRow - r][currCol] == '\0') {
				board[currRow - r][currCol] = '\0';
				board[currRow][currCol] = '\0';
			}
			if (board[currRow - r][currCol] == 'M') {
				int curRow = currRow - r;
				int curCol = currCol;
				dynamiteBomb(board, curRow, curCol);
			}

			// left
			if (board[currRow][currCol - r] == 'P') {
				System.out.println("Player died.");
				System.exit(0);
			}
			if (board[currRow][currCol - r] == 'V' || board[currRow][currCol - r] == 'B'
					|| board[currRow][currCol - r] == '\0') {
				board[currRow][currCol - r] = '\0';
				board[currRow][currCol] = '\0';
			}
			if (board[currRow][currCol - r] == 'M') {
				int curRow = currRow;
				int curCol = currCol - r;
				dynamiteBomb(board, curRow, curCol);
			}

			// right
			if (board[currRow][currCol + r] == 'P') {
				System.out.println("Player died.");
				System.exit(0);
			}
			if (board[currRow][currCol + r] == 'V' || board[currRow][currCol + r] == 'B'
					|| board[currRow][currCol + r] == '\0') {
				board[currRow][currCol + r] = '\0';
				board[currRow][currCol] = '\0';
			}
			if (board[currRow][currCol + r] == 'M') {
				int curRow = currRow;
				int curCol = currCol + r;
				dynamiteBomb(board, curRow, curCol);
			}

			// move up left diagonal
			if (board[currRow - r][currCol - r] == 'P') {
				System.out.println("Player died.");
				System.exit(0);
			}
			if (board[currRow - r][currCol - r] == 'V' || board[currRow - r][currCol - r] == 'B'
					|| board[currRow - r][currCol - r] == '\0') {
				board[currRow - r][currCol - r] = '\0';
				board[currRow][currCol] = '\0';
			}
			if (board[currRow - r][currCol - r] == 'M') {
				int curRow = currRow - r;
				int curCol = currCol - r;
				dynamiteBomb(board, curRow, curCol);
			}

			// move down left diagonal
			if (board[currRow + r][currCol - r] == 'P') {
				System.out.println("Player died.");
				System.exit(0);
			}
			if (board[currRow + r][currCol - r] == 'V' || board[currRow + r][currCol - r] == 'B'
					|| board[currRow + r][currCol - r] == '\0') {
				board[currRow + r][currCol - r] = '\0';
				board[currRow][currCol] = '\0';
			}
			if (board[currRow + r][currCol + r] == 'M') {
				int curRow = currRow + r;
				int curCol = currCol + r;
				dynamiteBomb(board, curRow, curCol);
			}

			// move up right diagonal
			if (board[currRow - r][currCol + r] == 'P') {
				System.out.println("Player died.");
				System.exit(0);
			}
			if (board[currRow - r][currCol + r] == 'V' || board[currRow - r][currCol + r] == 'B'
					|| board[currRow - r][currCol + r] == '\0') {
				board[currRow - r][currCol + r] = '\0';
				board[currRow][currCol] = '\0';
			}
			if (board[currRow - r][currCol + r] == 'M') {
				int curRow = currRow - r;
				int curCol = currCol + r;
				dynamiteBomb(board, curRow, curCol);
			}

			// move down right diagonal
			if (board[currRow + r][currCol + r] == 'P') {
				System.out.println("Player died.");
				System.exit(0);
			}
			if (board[currRow + r][currCol + r] == 'V' || board[currRow + r][currCol + r] == 'B'
					|| board[currRow + r][currCol + r] == '\0') {
				board[currRow + r][currCol + r] = '\0';
				board[currRow][currCol] = '\0';
			}
			if (board[currRow + r][currCol + r] == 'M') {
				int curRow = currRow + r;
				int curCol = currCol + r;
				dynamiteBomb(board, curRow, curCol);
			}
			r++;
		}

	}

	private void getInput(char[][] board) {
		boolean boolValue = true;
		while (boolValue) {
			System.out.println("Enter the Player Position");
			String posi = scanner.next();
			playerPosition[0] = posi.charAt(0) - 64;
			playerPosition[1] = posi.charAt(1) - 64;
			if (checkPosition(playerPosition[0], playerPosition[1])) {
				board[playerPosition[0]][playerPosition[1]] = 'P';
				printBoard(board);
				boolValue = false;
			}
		}
		boolean boolValue1 = true;
		while (boolValue1) {
			System.out.println("Enter the Key Position");
			String posi = scanner.next();
			keyPosition[0] = posi.charAt(0) - 64;
			keyPosition[1] = posi.charAt(1) - 64;
			if (checkPosition(keyPosition[0], keyPosition[1])) {
				board[keyPosition[0]][keyPosition[1]] = 'K';
				printBoard(board);
				boolValue1 = false;
			}
		}
		boolean boolValue2 = true;
		while (boolValue2) {
			System.out.println("Enter the number of villains and positions : ");
			int noVillains = scanner.nextInt();
			if (noVillains == 0) {
				boolValue2 = false;
			} else {
				for (int i = 0; i < noVillains; i++) {
					String posi = scanner.next();
					if (checkPosition(posi.charAt(0) - 64, posi.charAt(1) - 64)) {
						board[posi.charAt(0) - 64][posi.charAt(1) - 64] = 'V';
						boolValue2 = false;
					} else {
						break;
					}
				}
			}
		}
		printBoard(board);
		boolean boolValue3 = true;
		while (boolValue3) {
			System.out.println("Enter the number of bricks and positions : ");
			int nobricks = scanner.nextInt();
			if (nobricks == 0) {
				boolValue3 = false;
			} else {
				for (int i = 0; i < nobricks; i++) {
					String posi = scanner.next();
					if (checkPosition(posi.charAt(0) - 64, posi.charAt(1) - 64)) {
						board[posi.charAt(0) - 64][posi.charAt(1) - 64] = 'B';
						boolValue3 = false;
					} else {
						break;
					}
				}
			}
		}
		printBoard(board);
		boolean boolValue4 = true;
		while (boolValue4) {
			System.out.println("Enter the number of power 1 and positions :");
			int noPower1 = scanner.nextInt();
			if (noPower1 == 0) {
				boolValue4 = false;
			} else {
				for (int i = 0; i < noPower1; i++) {
					String posi = scanner.next();
					if (checkPosition(posi.charAt(0) - 64, posi.charAt(1) - 64)) {
						board[posi.charAt(0) - 64][posi.charAt(1) - 64] = '1';
						boolValue4 = false;
					} else {
						break;
					}
				}
			}
		}
		printBoard(board);
		boolean boolValue5 = true;
		while (boolValue5) {
			System.out.println("Enter the number of power 2 and positions :");
			int noPower2 = scanner.nextInt();
			if (noPower2 == 0) {
				boolValue5 = false;
			} else {
				for (int i = 0; i < noPower2; i++) {
					String posi = scanner.next();
					if (checkPosition(posi.charAt(0) - 64, posi.charAt(1) - 64)) {
						board[posi.charAt(0) - 64][posi.charAt(1) - 64] = '2';
						boolValue5 = false;
					} else {
						break;
					}
				}
			}
		}
		printBoard(board);
		boolean boolValue6 = true;
		while (boolValue6) {
			System.out.println("Enter the number of power 3 and positions :");
			int noPower3 = scanner.nextInt();
			if (noPower3 == 0) {
				boolValue6 = false;
			} else {
				for (int i = 0; i < noPower3; i++) {
					String posi = scanner.next();
					if (checkPosition(posi.charAt(0) - 64, posi.charAt(1) - 64)) {
						board[posi.charAt(0) - 64][posi.charAt(1) - 64] = '3';
						boolValue6 = false;
					} else {
						break;
					}
				}
			}
		}
		printBoard(board);
		boolean boolValue7 = true;
		while (boolValue7) {
			System.out.println("Enter the number of  dynamite bomb and positions : ");
			int noDynamite = scanner.nextInt();
			if (noDynamite == 0) {
				boolValue7 = false;
			} else {
				for (int i = 0; i < noDynamite; i++) {
					String posi = scanner.next();
					if (checkPosition(posi.charAt(0) - 64, posi.charAt(1) - 64)) {
						board[posi.charAt(0) - 64][posi.charAt(1) - 64] = 'M';
						boolValue7 = false;
					} else {
						break;
					}
				}
			}
		}
		printBoard(board);
	}

	private boolean checkPosition(int row, int col) {
		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
			System.out.println("Out of Map Size");
			return false;
		} else if (board[row][col] != '\0') {
			System.out.println("Position Occupied");
			return false;
		}
		return true;
	}

	private void setBoard(char[][] board) {
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

	private static void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
