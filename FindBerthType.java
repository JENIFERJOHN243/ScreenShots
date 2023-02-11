package task;

import java.util.Scanner;

class FindBerthType {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Seat Number");
		findBerth(scanner.nextInt());
	}
	
	private static void findBerth(int input) {
			if (input>0 && input<73)
				if (input%8==1 || input%8==4)
					System.out.println(input+" is lower berth");
				else if (input%8==2 || input%8==5)
					System.out.println(input+" is middle berth");
				else if (input%8==3 || input%8==6)
					System.out.println(input+" is upper berth");
				else if (input%8==7)
					System.out.println(input+" is side lower berth");
				else
					System.out.println(input+" is side upper berth");
			else
				System.out.println(input+" invalid seat number");
		}
	}
