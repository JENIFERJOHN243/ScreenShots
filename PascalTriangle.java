package task;

import java.util.Scanner;

public class PascalTriangle {

	public static void main(String[] args) {
		PascalTriangle pascalTriangle = new PascalTriangle();
		pascalTriangle.printPattern();
	}

	private void printPattern() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the no of lines");
		int lines= scanner.nextInt();
		for(int row = 0;row<lines;row++) {
			for(int space=0;space<=lines-row;space++) {
				System.out.print(" ");
			}
			for(int col=0;col<=row;col++) {
				System.out.print(" "+factorial(row)/(factorial(row-col)*factorial(col)));
			}
			System.out.println();
		}
	}

	private int factorial(int no) {
		if(no==0) {
			return 1;
		}
		return no*factorial(no-1);
	}

}
