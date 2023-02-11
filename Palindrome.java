package task;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Palindrome palindrome = new Palindrome();
		System.out.println(palindrome.start());
	}

	private boolean start() {
		Scanner scanner = new Scanner(System.in);
		String input1 = scanner.next();
		String input2 = scanner.next();
		
		//printPermute(input2,0,input2.length());
		if(checkifPalindrome(input1)&&(checkPermutation(input1,input2))) {
			return true;
			}else {
			System.out.println("Not an plaindrome / Not an permutation of an plaindrome");
			return false;
		}
	} 

//	private void printPermute(String input2, int start, int end) {
//		if(start==end-1) {
//			System.out.println(input2);
//		}
//		for(int index=start;index<end;index++) {
//		String swap = swap(input2,start,index);
//		printPermute(input2,start+1,end);
//		swap = swap(input2,start,index);
//		System.out.println(swap);
//		}
//	}
//
//	private String swap(String input2, int start, int end ) {
//		char[] array = input2.toCharArray();
//		char temp;
//		temp=array[start];
//		array[start]=array[end];
//		array[end]=temp;
//		return String.valueOf(array);
//	}
//
	private boolean checkifPalindrome(String input1) {
		String reverse = "";
		for(int index= (input1.length())-1;index>=0;index--) {
			reverse = reverse + input1.charAt(index);
		}
		if(input1.equals(reverse)) {
			return true;
		}else {
			return false;
		}
	}

	private boolean checkPermutation(String input1, String input2) {
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
