package task;

import java.util.HashMap;
import java.util.Scanner;

public class EquivalentArrays {

	public static void main(String[] args) {
		EquivalentArrays equalArray = new EquivalentArrays();
		System.out.println(equalArray.getArrayElements());
	}

	private String getArrayElements() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the no of elements (N)");
		int N = scanner.nextInt();
		int[] arrayA = new int[N];
		int[] arrayB = new int[N];
		System.out.println("Enter the elements of an Array A");
		for(int arrayIndex = 0;arrayIndex<N;arrayIndex++) {
			arrayA[arrayIndex]=scanner.nextInt();
		}
		System.out.println("Enter the elements of an Array B");
		for(int arrayIndex = 0;arrayIndex<N;arrayIndex++) {
			arrayB[arrayIndex]=scanner.nextInt();
		}
		if(findEquivalentArray(arrayA,arrayB)) {
			return "Equal";
		}else {
			return "Not Equal";
		}
	}

	private boolean findEquivalentArray(int[] arrayA, int[] arrayB) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int value : arrayA) {
			map.put(value, map.getOrDefault(value, 0)+1);
		}
		for(int value : arrayB) {
			if(map.containsKey(value)) {
				map.put(value,map.get(value)-1);
			}
		}
		for(int value : map.values()) {
			if(value!=0) return false;
		}
		//System.out.println(map.values());
		return true;
	}

}
