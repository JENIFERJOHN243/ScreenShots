package task;

import java.util.ArrayList;
import java.util.Scanner;

class Kaviya {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		ArrayList<Integer> year1=new ArrayList<>();
		year1.add(1904);
		year1.add(1902);
		year1.add(19032);
		year1.add(1902);
		ArrayList<Integer> year2=new ArrayList<>();
		year1.add(1904);
		year1.add(1902);
		year1.add(19032);
		year1.add(1902);
		int max=0,count=0;
		int resultantYear=0;
		for(int i=0;i<year1.size();i++)
		{
			for(int k=1;k<year2.size();k++)
			{
				if(year1.get(k)<=year1.get(i)&&year2.get(k)>=year1.get(i));
				{
					count++;
					if(count>max)
					{
						max=count;
						resultantYear=year1.get(i);
					}
				}
			}
		}
		System.out.println(resultantYear);
		
	}

}