package task;

import java.util.Scanner;

public class StringWithoutSpace {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		//String s = "Hello World very";
		//s=s.trim();
		String ans ="";
		for(int i = 0;i<s.length();i++) {
			if(s.charAt(i)!=' ') {
				ans +=s.charAt(i);
			}else {
				continue;
			}
		}
		System.out.println(ans);
	}

}
