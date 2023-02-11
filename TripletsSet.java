package task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class TripletsSet {

	public static void main(String[] args) {
		getInput();
	}

	private static void getInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the length of an array");
		int[] inputArray = new int[scanner.nextInt()];
		System.out.println("Enter the elements of an array");
		for(int arrayIndex=0;arrayIndex<inputArray.length;arrayIndex++) {
			inputArray[arrayIndex]=scanner.nextInt();
		}

		HashSet<ArrayList<Integer>> resultList = new LinkedHashSet<>();
		Arrays.sort(inputArray);
		int i=0;
		while(i<inputArray.length) {
				int j=i+1,k=i+2;
				while(j<inputArray.length&&k<inputArray.length) {
					ArrayList<Integer> row = new ArrayList<>();
					if(inputArray[i]+inputArray[j]+inputArray[k]==0) {
						row.add(inputArray[i]);
						row.add(inputArray[j]);
						row.add(inputArray[k]);
						resultList.add(row);
					}
					j++;
					k++;
				}
				i++;
			}
		System.out.println(resultList);   
	}

}
