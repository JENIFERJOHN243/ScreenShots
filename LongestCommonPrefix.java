package task;

import java.util.Arrays;

public class LongestCommonPrefix {

	public static void main(String[] args) {
    findLongestCommonPrefix();
	}

	private static void findLongestCommonPrefix() {
		//String[] strs = {"technique", "technician", "technology", "technical"};
		String[] strs = {"techie delight", "tech", "techie", "technology", "technical"};
		if(strs.length==0) System.out.println(strs[0]);
		Arrays.sort(strs);
		String result = "";
	    String subString = "";
	    for(int index = 0;index<strs[0].length();index++){
	    subString = strs[0].substring(0,index+1);
	    if(strs[strs.length-1].startsWith(subString)){
	    result = subString;
	    }
	 }
	   System.out.println(result); 
	}
}
