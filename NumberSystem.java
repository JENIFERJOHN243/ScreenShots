package task;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberSystem {
		public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int nthNumber = scanner.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(5);
		int startIndex = 2;
		for(int i=0;i<3-1;i++){
		list.add((i+startIndex) ,((list.get(i)*10)+1));
		startIndex++;
		list.add((i+startIndex),((list.get(i)*10)+5));
		}
		System.out.println(list);
		System.out.print(list.get((nthNumber)-1));
		}		
}
