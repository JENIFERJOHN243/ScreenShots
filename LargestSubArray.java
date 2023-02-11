package task;

import java.util.Scanner;

public class LargestSubArray {

	public static void main(String[] args) {
		LargestSubArray largestSubarray = new LargestSubArray();
		System.out.println(largestSubarray.getArrayElements());
	}

	private int getArrayElements() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the no of elements (N)");
		int N = scanner.nextInt();
		int[] arrayA = new int[N];
		System.out.println("Enter the elements of an Array A");
		for(int arrayIndex = 0;arrayIndex<N;arrayIndex++) {
			arrayA[arrayIndex]=scanner.nextInt();
		}
		return findLargestSubarray(arrayA);
	}

	private int findLargestSubarray(int[] arrayA) {
		int maxSum = 0;
		for(int element : arrayA) {
			maxSum+=element;
		}
		//System.out.println(maxSum);
		int start = 0, end = arrayA.length-1;
		while(start<end) {
			if(maxSum==0) {
				return start+end;
			}
			if(arrayA[start]>arrayA[end]) {
				maxSum-=arrayA[start];
				start++;
			}else {
				maxSum-=arrayA[end];
				end--;
			}
		}
		return -1;
	}

}
