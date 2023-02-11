package task;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StringFrequency {

	public static void main(String[] args) {
		LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter a String");
		String input = scanner.next();
		char[] charArray =input.toCharArray();
		for(char c :charArray) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
	    for(Map.Entry<Character, Integer> k :map.entrySet()) {
	    	if(k.getValue()==1) {
	    		System.out.print(k.getKey());
	    	}else {
	    		System.out.print(k.getKey()+""+k.getValue());
	    	}
       }
	}
}
