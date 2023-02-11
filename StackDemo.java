package task;
import java.util.*;
public class StackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println(decode(sc.next()));
	}

private static String decode(String str) {
		
		StringBuilder s = new StringBuilder();
		
		Stack<Integer> st = new Stack<>();
		
		for(int i=0 ; i<=str.length() ; i++) {
			
			st.push(i+1);
			
			if(i==str.length() || str.charAt(i)=='I')
				while(!st.isEmpty())
					s.append(st.pop());
		}
			
		
		return s.toString();
	}
}
