package task;

import java.util.Scanner;

public class SingleElementInSortedArray {

	public static void main(String[] args) {
		findSingleElement();
	}

	private static void findSingleElement() {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter the length of an Array");
//		int arrayLength = scanner.nextInt();
//		int[] arr = new int[arrayLength];
//		for(int arrayIndex=0;arrayIndex<arrayLength;arrayIndex++) {
//			arr[arrayIndex] = scanner.nextInt();
//		}
		int[] arr = {1, 1,2,2,4,5,5,7,7};
		if(arr.length==0) System.out.println(arr[0]);
		int start =0, end=arr.length-1;
		while(start<end) {
			int mid = start + (end-start)/2;
			//System.out.println(mid);
			if((mid%2==1 && arr[mid]==arr[mid-1]) || (mid%2==0 && arr[mid]==arr[mid+1])) start=mid+1;
			else end=mid;
		}
		System.out.println(arr[start]);
	}

}
