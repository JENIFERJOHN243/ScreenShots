package task;

import java.util.ArrayList;

public class HeightestInCount {

	public static void main(String[] args) {
		HeightestInCount object = new HeightestInCount();
		object.start();
	}

	private void start() {
		// TODO Auto-generated method stub
		ArrayList<Integer>list=new ArrayList<>();
		list.add(1904);
		list.add(1902);
		list.add(1932);
		list.add(1902);
		list.add(1901);
		list.add(1900);
		
		ArrayList<Integer>list1=new ArrayList<>();
		list1.add(1908);
		list1.add(1904);
		list1.add(1935);
		list1.add(1906);
		list1.add(1910);
		list1.add(1901);
		
		int year=0,temp=0;
		
		for(int i=0;i<list.size();i++) {
			int input=list.get(i);
			for(int j=1;j<list1.size();j++) {
				if((list.get(j)<=input)&&(list1.get(j)>=input)) {
					temp=input;
					year=temp;
				}
				break;
			}
		}
		System.out.println("Maximum People in India : "+year); 
	}

}
