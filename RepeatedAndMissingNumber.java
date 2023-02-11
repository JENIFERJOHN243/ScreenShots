package task;

import java.util.ArrayList;

public class RepeatedAndMissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>();
		int[] a = {3,1,2,5,4,6,7,5};
		int[] ans = new int[a.length];//{0-N}
		for(int i:a) {
			ans[i]++;
		}
		for(int i=0;i<ans.length;i++) {
			if(ans[i]>1) list.add(i);
			if(ans[i]==0) list.add(i);
		}
		System.out.println(list);
	}

}
