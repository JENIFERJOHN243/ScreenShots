package task;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class SnakeLadder {

	boolean userStatus = true;
	boolean computerStatus = false;
	static boolean win = false;
	int user, computer = 0;

	public static void main(String[] args) {
		SnakeLadder snakeAndLaddderUsingMap = new SnakeLadder();

		do {

			Scanner reader = new Scanner(System.in);
			if (snakeAndLaddderUsingMap.userStatus) {

				System.out.println("Ur Turn please play  press any number");
				int choice = reader.nextInt();
			} else {
				System.out.println("Computer Plays");
			}
			Random random = new Random();
			int diceValue = random.nextInt(7);
			diceValue = diceValue == 0 ? diceValue + 1 : diceValue;
			System.out.println("Dice value " + diceValue);
			snakeAndLaddderUsingMap.playing(diceValue);
			System.out.println("User Place     : " + snakeAndLaddderUsingMap.user);
			System.out.println("Computer Place : " + snakeAndLaddderUsingMap.computer);

		} while (!win);
		System.out.println("Thanks For Playing");

	}

	private void playing(int diceValue) {

		Map<Integer, Integer> snakeValues = new HashMap<Integer, Integer>();
		snakeValues.put(17, 7);
		snakeValues.put(54, 34);
		snakeValues.put(64, 19);
		snakeValues.put(62, 59);
		snakeValues.put(87, 24);
		snakeValues.put(93, 73);
		snakeValues.put(95, 75);
		snakeValues.put(98, 79);

		Map<Integer, Integer> ladderValues = new HashMap<Integer, Integer>();
		ladderValues.put(4, 14);
		ladderValues.put(19, 38);
		ladderValues.put(28, 84);
		ladderValues.put(52, 67);

		if (userStatus) {
			user += diceValue;
			if (100 < user) {
				user -= diceValue;
			} else if (user == 100) {
				System.out.println("User Winss");
				win = true;
			} else {
				if (snakeValues.containsKey(user)) {
					System.out.println("\nYou got Bitten " + user + " to " + snakeValues.get(user) + "\n");
					user = snakeValues.get(user);
				}

				else if (ladderValues.containsKey(user)) {
					System.out.println("\nYou Power Up " + user + " to " + ladderValues.get(user) + "\n");
					user = ladderValues.get(user);
				}
			}
			userStatus = false;

		} else {
			computer += diceValue;
			if (100 < computer) {
				computer -= diceValue;
			} else if (computer == 100) {
				System.out.println("Computer Winss");
				win = true;
			} else {
				if (snakeValues.containsKey(computer)) {
					System.out.println("\nComputer got Bitten " + computer + " to " + snakeValues.get(computer) + "\n");
					computer = snakeValues.get(computer);

				}

				else if (ladderValues.containsKey(computer)) {
					System.out.println("\nComputer Power Up " + computer + " to " + ladderValues.get(computer) + "\n");
					computer = ladderValues.get(computer);
				}
			}

			userStatus = true;
		}
	}

}