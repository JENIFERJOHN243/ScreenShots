package task;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UnqiueElement {

	public static void main(String[] args) {
		UnqiueElement unqiue = new UnqiueElement();
		//System.out.println(unqiue.start());
		System.out.println(unqiue.checkUnqiue());
	}

	private boolean start() {
		Scanner scanner = new Scanner(System.in);
		String input1 = scanner.next();
		int array[]=new int[26];
		for(int index=0;index<input1.length();index++) {
			if(array[input1.charAt(index)-97]==0) {
				array[input1.charAt(index)-97]++;
			}
			else {
		return false;
		}
	}
    return true;
}
	
	private boolean checkUnqiue() {
		Scanner scanner = new Scanner(System.in);
		String input1 = scanner.next();
		HashMap<Character,Integer> unqiue = new HashMap<>();
		char[] charArray = input1.toCharArray();
		for(char index : charArray) {
			if(unqiue.containsKey(index)) {
			unqiue.put(index, unqiue.get(index)+1);
			}
			else {
				unqiue.put(index, 0);
			}
		}
		for(Map.Entry<Character, Integer> display : unqiue.entrySet()) {
			if(display.getValue()!=0) {
				return false;
			}
		}
		return true;
		
	}
}
