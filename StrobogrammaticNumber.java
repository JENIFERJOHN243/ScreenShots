package task;

import java.util.Scanner;

public class StrobogrammaticNumber {

	public static void main(String[] args) {
		StrobogrammaticNumber strobogrammaticNumber = new StrobogrammaticNumber();
		if(strobogrammaticNumber.checkStrobogrammatic()) {
			System.out.println("It is an Strobogrammatic Number");
		}else {
			System.out.println("It is not an Strobogrammatic Number");
		}
	}

	private boolean checkStrobogrammatic() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter an number");
		int inputNumber = scanner.nextInt();
		while(inputNumber>0) {
			int remainder = inputNumber%10;
			if(remainder==0||remainder==1||remainder==6||remainder==8||remainder==9) {
				inputNumber/=10;
				continue;
			}
			else {
				return false;
			}
		}
		return true;
	}

}
