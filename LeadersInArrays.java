package task;

import java.util.ArrayList;
import java.util.Scanner;

public class LeadersInArrays {

	public static void main(String[] args) {
		LeadersInArrays leadersArray = new LeadersInArrays();
		leadersArray.getArrayElements();
	}

	private void getArrayElements() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the no of elements (N)");
		int N = scanner.nextInt();
		int[] arrayA = new int[N];
		System.out.println("Enter the elements of Arrays");
		for(int arrayIndex = 0;arrayIndex<N;arrayIndex++) {
			arrayA[arrayIndex]=scanner.nextInt();
		}
		System.out.println(findLeadersArray(arrayA));
	}

	private ArrayList<Integer> findLeadersArray(int[] arrayA) {
		ArrayList<Integer> leaderList = new ArrayList<>();
		int start = 0, end = arrayA.length-1;
		while(start<end) {
			if(arrayA[start]>arrayA[end]) {
				end--;
			}else {
				start++;
				end=arrayA.length-1;
			}
			if(arrayA[start]==arrayA[end]) {
				leaderList.add(arrayA[start]);
				start++;
				end=arrayA.length-1;
			}
		}
		leaderList.add(arrayA[arrayA.length-1]);
		//System.out.println(leaderList);
		return leaderList;
	}

}
