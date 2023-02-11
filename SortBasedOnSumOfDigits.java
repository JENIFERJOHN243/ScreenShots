package task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

public class SortBasedOnSumOfDigits {

	public static void main(String[] args) {
		int[] a = {12,43,51,11};
//		int start=0,end=a.length-1;
//		while(start<end) {
//			if(sum(a[start])>sum(a[end])) {
//				int temp = a[end];
//				a[end]=a[start];
//				a[start]=temp;
//				end--;
//			}else {
//				start++;
//			}
//		}
//		for(int i=0;i<a.length;i++) {
//			System.out.print(a[i]+" ");
//		}
		
	HashMap<Integer,Integer> map = new HashMap<>();
	for(int i : a) {
		map.put(i, sum(i));
	}
	//System.out.println(map);	
	ArrayList<Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
	//System.out.println(list);
	Collections.sort(list, new Comparator<Entry<Integer, Integer>>() 
    {
        
        public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) 
        {
            return o1.getValue().compareTo(o2.getValue());
        }
    });
	//System.out.println(list);
	for(Entry<Integer,Integer>entry:list) {
		System.out.print(entry.getKey()+" ");
	}
	}

	private static int sum(int i) {
		int sum=0;
		while(i!=0) {
			int rem = i%10;
			sum+=rem;
			i=i/10;
		}
		//System.out.println(sum);
		return sum;
	}

}
