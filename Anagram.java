package task;

import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {
		Anagram anagram = new Anagram();
		System.out.println(anagram.start());
	}

	private boolean start() {
		Scanner scanner = new Scanner(System.in);
		String input1 = scanner.next();
		String input2 = scanner.next();
		int array[]=new int[26];
		for(int index=0;index<input1.length();index++) {
				array[input1.charAt(index)-97]++;
		}
		for(int index=0;index<input2.length();index++) {
				array[input2.charAt(index)-97]--;
		}
		for(int index=0;index<26;index++) {
			if(array[index]!=0) {
				return false;
			}
		}
		return true;
	}
}
