package task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class FrequencyOfElements {

	public static void main(String[] args) {
		int []arr= {0, 2, 1, -1, 1, 2, 0, 4, -1, 4};
		//int []arr= {4, 6, 8, 2, 5, 7, 9};
		Arrays.sort(arr);
		LinkedHashMap<Integer,Integer> map=new LinkedHashMap<>();
		for(int i:arr)
		{
			map.put(i,map.getOrDefault(i,0)+1);
		}
		ArrayList<Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
		//System.out.println(list);
		 Collections.sort(list, new Comparator<Entry<Integer, Integer>>() 
         {
             @Override
             public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) 
             {
                 return o2.getValue().compareTo(o1.getValue());
             }
         }
		 );
		 //System.out.println(list);
		 for(Entry<Integer,Integer>entry:list)
		 {
			 int frequency=entry.getValue();
			 while(frequency>=1)
			 {
				 System.out.print(entry.getKey()+" ");
				 frequency--;
			 }
		 }
	}
}
