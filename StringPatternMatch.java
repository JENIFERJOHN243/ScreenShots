package task;

import java.util.Scanner;

public class StringPatternMatch {

	public static void main(String[] args) {
		StringPatternMatch patternObject = new StringPatternMatch();
		patternObject.startProcess();
	}

	private void startProcess() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a String Input 1");
		String input1 = scanner.next();
		System.out.println("Enter a String Input 2");
		String input2 = scanner.next();
		char startIndex=input1.charAt(0);
		int start=0;
		for(int index=1;index<input1.length();index++) {
			if(input1.charAt(index++)==startIndex){
				start++;
				if(input1.charAt(index)==input1.charAt(start)) {
					
				}
			}
		}
	}

}
