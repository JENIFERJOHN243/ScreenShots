

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BomberMan {
	Scanner scanner = new Scanner(System.in);
	int n = 12;
	char[][] bomberManMap;
	int[] playerPostion = new int[2];
	int[] keyPostion = new int[2];
	int range = 1;
	int bombCapacity = 1;
	boolean bombplanted = false;
	ArrayList<ArrayList<Integer>> villainPosition = new ArrayList<>();
	ArrayList<ArrayList<Integer>> bricksPosition = new ArrayList<>();
	Queue<ArrayList<Integer>> bombPosition = new LinkedList<>();

	public static void main(String[] args) {
		BomberMan bm = new BomberMan();
		bm.input();
		bm.printMap();
		bm.gameStarts();
	}

	public void gameStarts() {

		while (move()) {
			printMap();
			if (playerPostion[0] == keyPostion[0] && playerPostion[1] == keyPostion[1]) {
				System.out.println("<< Player won the game >>");
				break;
			}
		}

	}

	public boolean move() {
		int row = playerPostion[0];
		int col = playerPostion[1];
		System.out.println("Enter the direction key : ");
		char dir = scanner.next().charAt(0);
		switch (dir) {
		case 'W': // move up
			if (row > 2 && bomberManMap[row - 1][col] != 'B') {
				if (bomberManMap[row - 1][col] == 'V') {
					System.out.println("Player died.");
					return false;
				}
				playerPostion[0] = row - 1;
				bomberManMap[playerPostion[0]][col]='P';
				bomberManMap[row][col] = ' ';
			} else {
				System.out.println("Invalid Move");
			}
			break;
		case 'S': // move down
			if (row < n - 2 && bomberManMap[row + 1][col] != 'B') {
				if (bomberManMap[row + 1][col] == 'V') {
					System.out.println("Player died.");
					return false;
				}
				playerPostion[0] = row + 1;
				bomberManMap[row][col] = ' ';
			} else {
				System.out.println("Invalid Move");
			}
			break;
		case 'A': // move left
			if (col > 2 && bomberManMap[row][col - 1] != 'B') {
				if (bomberManMap[row][col - 1] == 'V') {
					System.out.println("Player died.");
					return false;
				}
				playerPostion[1] = col - 1;
				bomberManMap[row][col] = ' ';
			} else {
				System.out.println("Invalid Move");
			}
			break;
		case 'D': // move right
			if (col < n - 2 && bomberManMap[row][col + 1] != 'B') {
				if (bomberManMap[row][col + 1] == 'V') {
					System.out.println("Player died.");
					return false;
				}
				playerPostion[1] = col + 1;
				bomberManMap[row][col] = ' ';
			} else {
				System.out.println("Invalid Move");
			}
			break;
		case 'Q': // move up left diagonal
			if (row > 2 && col > 2 && bomberManMap[row - 1][col - 1] != 'B') {
				if (bomberManMap[row - 1][col - 1] == 'V') {
					System.out.println("Player died.");
					return false;
				}
				playerPostion[0] = row - 1;
				playerPostion[1] = col - 1;
				bomberManMap[row][col] = ' ';
			} else {
				System.out.println("Invalid Move");
			}
			break;
		case 'Z': // move down left diagonal
			if (row < n - 2 && col > 2 && bomberManMap[row + 1][col - 1] != 'B') {
				if (bomberManMap[row + 1][col - 1] == 'V') {
					System.out.println("Player died.");
					return false;
				}
				playerPostion[0] = row + 1;
				playerPostion[1] = col - 1;
				bomberManMap[row][col] = ' ';
			} else {
				System.out.println("Invalid Move");
			}
			break;
		case 'E': // move up right diagonal
			if (row > 2 && col < n - 2 && bomberManMap[row - 1][col + 1] != 'B') {
				if (bomberManMap[row - 1][col + 1] == 'V') {
					System.out.println("Player died.");
					return false;
				}
				playerPostion[0] = row - 1;
				playerPostion[1] = col + 1;
				bomberManMap[row][col] = ' ';
			} else {
				System.out.println("Invalid Move");
			}
			break;
		case 'C': // move down right diagonal
			if (row < n - 2 && col < n - 2 && bomberManMap[row + 1][col + 1] != 'B') {
				if (bomberManMap[row + 1][col + 1] == 'V') {
					System.out.println("Player died.");
					return false;
				}
				playerPostion[0] = row + 1;
				playerPostion[1] = col + 1;
				bomberManMap[row][col] = ' ';
			} else {
				System.out.println("Invalid Move");
			}
			break;
		case 'X' :
			setBomb(row,col);
			break;
		default:
			System.out.println("Invalid Input");
		}
		return true;
	}

	public void setBomb(int row, int col) {
		System.out.println("1. plant.");
		System.out.println("2. Detonate.");
		int choose = scanner.nextInt();

		switch (choose) {
		case 1:
			if (bombCapacity > bombPosition.size() && !bombplanted) {
				ArrayList<Integer> position = new ArrayList<>();
				position.add(row);
				position.add(col);
				bombPosition.add(position);
				bombplanted = true;
			}
			break;
		case 2:
			if (bombPosition.isEmpty()) {
				System.out.println("No bomb is planted to detonate");
				break;
			}

			while (!bombPosition.isEmpty()) {
				ArrayList<Integer> postion = bombPosition.poll();
				int r = 1;
				while (r <= range) {
					// down
					if (bomberManMap[postion.get(0) + r][postion.get(1) + r] == 'P') {
						System.out.println("Player died.");
					}
					if (bomberManMap[postion.get(0) + r][postion.get(1) + r] == 'V'
							|| bomberManMap[postion.get(0) + r][postion.get(1) + r] == 'B') {
						bomberManMap[postion.get(0) + r][postion.get(1) + r] = ' ';
					}

					// up
					if (bomberManMap[postion.get(0) - r][postion.get(1) + r] == 'P') {
						System.out.println("Player died.");
					}
					if (bomberManMap[postion.get(0) - r][postion.get(1) + r] == 'V'
							|| bomberManMap[postion.get(0) - r][postion.get(1) + r] == 'B') {
						bomberManMap[postion.get(0) - r][postion.get(1) + r] = ' ';
					}

					// left
					if (bomberManMap[postion.get(0)][postion.get(1) - r] == 'P') {
						System.out.println("Player died.");
					}
					if (bomberManMap[postion.get(0)][postion.get(1) - r] == 'V'
							|| bomberManMap[postion.get(0)][postion.get(1) - r] == 'B') {
						bomberManMap[postion.get(0) + r][postion.get(1) + r] = ' ';
					}

					// right
					if (bomberManMap[postion.get(0)][postion.get(1) + r] == 'P') {
						System.out.println("Player died.");
					}
					if (bomberManMap[postion.get(0)][postion.get(1) + r] == 'V'
							|| bomberManMap[postion.get(0)][postion.get(1) + r] == 'B') {
						bomberManMap[postion.get(0)][postion.get(1) + r] = ' ';
					}
					r++;
				}
			}

		}
	}

	public void input() {
		System.out.println("Enter the map size (n x n) :");
		n = scanner.nextInt();
		bomberManMap = new char[n][n];
		map();
		printMap();

		System.out.println("Enter the Player Postion");
		String posi = scanner.next();
		playerPostion[0] = posi.charAt(0) - 64;
		playerPostion[1] = posi.charAt(1) - 64;

		System.out.println("Enter the Key Postion");
		posi = scanner.next();
		keyPostion[0] = posi.charAt(0) - 64;
		keyPostion[1] = posi.charAt(1) - 64;

		System.out.println("Enter the number of villains and postions : ");
		int noVillains = scanner.nextInt();
		for (int i = 0; i < noVillains; i++) {
			posi = scanner.next();
			ArrayList<Integer> position = new ArrayList<>();
			position.add(posi.charAt(0) - 64);
			position.add(posi.charAt(1) - 64);
			villainPosition.add(position);
		}

		System.out.println("Enter the number of bricks and postions : ");
		int nobricks = scanner.nextInt();
		for (int i = 0; i < nobricks; i++) {
			posi = scanner.next();
			ArrayList<Integer> position = new ArrayList<>();
			position.add(posi.charAt(0) - 64);
			position.add(posi.charAt(1) - 64);
			bricksPosition.add(position);
		}
	}

	public void map() {
		char letter = 'A';
		for (int j = 1; j < n; j++) {
			bomberManMap[0][j] = letter;
			bomberManMap[1][j] = '*';
			bomberManMap[n - 1][j] = '*';
			letter++;
		}
		letter = 'A';
		for (int j = 1; j < n; j++) {
			bomberManMap[j][0] = letter;
			bomberManMap[j][1] = '*';
			bomberManMap[j][n - 1] = '*';
			letter++;
		}
	}

	public void printMap() {
		map();
		bomberManMap[playerPostion[0]][playerPostion[1]] = 'P';
		bomberManMap[keyPostion[0]][keyPostion[1]] = 'K';
		bomberManMap[0][0] = ' ';
		for (int i = 0; i < villainPosition.size(); i++) {
			bomberManMap[villainPosition.get(i).get(0)][villainPosition.get(i).get(1)] = 'V';
		}

		for (int i = 0; i < bricksPosition.size(); i++) {
			bomberManMap[bricksPosition.get(i).get(0)][bricksPosition.get(i).get(1)] = 'B';
		}

		for (char[] row : bomberManMap) {
			for (char col : row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}

}
