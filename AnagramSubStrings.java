package task;

import java.util.ArrayList;
import java.util.Scanner;

public class AnagramSubStrings {

	public static void main(String[] args) {
		AnagramSubStrings anagramSubstring = new AnagramSubStrings();
		anagramSubstring.getInputString();
	}

	private void getInputString() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter an String");
		String inputString = scanner.next();
		findAnagramPairs(inputString);
	}
	
	private void findAnagramPairs(String input) {
		ArrayList< String > pairList = new ArrayList<>();
		int noOfPairs = 0;
		for(int indexI = 1 ; indexI<input.length() ;indexI++) {
			for(int indexJ=0 ; indexI+indexJ <= input.length() ; indexJ++) {
				pairList.add(input.substring(indexJ,indexI+indexJ));
			}
		}
		System.out.println(pairList);
		for(int listIndexOuter=0; listIndexOuter<pairList.size();listIndexOuter++) {
			 String input1 = pairList.get(listIndexOuter);
			 for(int listIndexInner=listIndexOuter+1;listIndexInner<pairList.size();listIndexInner++) {
				 String input2 = pairList.get(listIndexInner);
				 if(validAnagram(input1 , input2)) {
					 noOfPairs++;
				 }
			 }
		}
		System.out.println(noOfPairs);
	}

	private boolean validAnagram(String input1, String input2) {
		if(input1.length()!=input2.length()) 
		{
			return false;
		}
		if(input1.equals(input2)) {
			return true;
		}
		int array[] = new int [26];
		for(char character : input1.toCharArray()) {
			array[character-97]++;
		}
		for(char character : input2.toCharArray()) {
			array[character-97]--;
		}
		for(int value: array)
		{
			if(value!=0) 
			{
				return false;
			}
		}
		return true;
	}	
}
