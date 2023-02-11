package task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class StringLength {

	public static void main(String[] args) {
		StringLength object = new StringLength();
		object.start();
	}

	private void start() {
//		HashMap<Character,Integer> map = new HashMap<>();
//		Scanner scanner =new Scanner(System.in);
//		System.out.println("Enter a String");
//		String input = scanner.next();
//		char[] charArray =input.toCharArray();
//		for(char c :charArray) {
//			if(map.containsKey(c)) {
//				map.put(c, map.get(c)+1);
//			}else {
//				map.put(c, 1);
//			}
//		}
//	    for(Map.Entry<Character, Integer> k :map.entrySet()) {
//	    	System.out.print(k.getKey()+""+k.getValue());
//	    }
//	    System.out.println("LEETCODE");
	    HashMap<String,Integer> map1 = new LinkedHashMap<>();
	    map1.put("i", 2);
	    map1.put("love", 2);
	    map1.put("leetcode", 1);
	    map1.put("coding",1);
	    System.out.println(map1);
	    Set<Entry<String,Integer>> set = map1.entrySet();
	    ArrayList<Entry<String,Integer>> list = new ArrayList<>(map1.entrySet());
	    Collections.sort(list, (o1,o2)->o2.getValue().compareTo(o1.getValue()));
	    System.out.println(list);
	    System.out.println(map1);
	    int k=2;
	    ArrayList<String> j = new ArrayList<>();
        list.forEach(a->{
            if(j.size()<k) {
            	j.add(a.getKey());
            }
        });
        System.out.println(j);
	}
}
