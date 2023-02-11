package task;

import java.util.Scanner;

public class MinimumNumberWithoutRepeating {

	public static void main(String[] args) {
		getInput();
	}

	private static void getInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Sequence");
		String sequence = scanner.next();
		findMinimumNumberSequence(sequence);
	}

	private static void findMinimumNumberSequence(String sequence) {
		String result = "";
		int index =0,value=1,dCount=0;
		while(index<sequence.length()) {
			char character = sequence.charAt(index);
			if(index==0&&character=='I') {
				result+=value;
				value++;
			}
			if(character=='D') dCount++;
			int index1= index+1;
			while(index1<sequence.length() && sequence.charAt(index1)=='D') {
				dCount++;
				index1++;
			}
			int dCountTemp = dCount;
			while (dCount >= 0) {
				result += (value + dCount);
				dCount--;
			}
			value += (dCountTemp+ 1); 
			dCount = 0;
			index = index1;
		}
		System.out.println(result);
	}
}
