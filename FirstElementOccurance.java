package task;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FirstElementOccurance {

	public static void main(String[] args) {
		FirstElementOccurance firstOccurance = new FirstElementOccurance();
		firstOccurance.getArrayElements();
	}

	private void getArrayElements() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the no of elements (N)");
		int N = scanner.nextInt();
		System.out.println("Enter the Number of Times (K)");
		int K = scanner.nextInt();
		int[] arrayA = new int[N];
		System.out.println("Enter the elements of Arrays");
		for(int arrayIndex = 0;arrayIndex<N;arrayIndex++) {
			arrayA[arrayIndex]=scanner.nextInt();
		}
		System.out.println(findFirstElement(arrayA,K));
	}

	private int findFirstElement(int[] arrayA,int K) {
		LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
		for(int value : arrayA) {
			map.put(value, map.getOrDefault(value, 0)+1);
			if(map.get(value)==K){
				return value;
			}
		}
		return -1;
	}

}
