package task;

import java.util.Scanner;

public class FindTheDays {
	
	public static void main(String[] args) {
		FindTheDays days = new FindTheDays();
		System.out.println(days.findTheDays());
	}

	private int findTheDays() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter From Date");
		int fromDate = scanner.nextInt();
		System.out.println("Enter From Month");
		int fromMonth = scanner.nextInt();
		System.out.println("Enter From Year");
		int fromYear = scanner.nextInt();
		System.out.println("Enter To Date");
		int toDate = scanner.nextInt();
		System.out.println("Enter To Month");
		int toMonth = scanner.nextInt();
		System.out.println("Enter To Year");
		int toYear = scanner.nextInt();
		int yearDifference = (toYear-fromYear);
		if(yearDifference < 1) {
			if(toMonth==fromMonth) {
				int totalDate = (toDate-fromDate)+1;
				return totalDate;
			}
			int monthDifference =( toMonth - fromMonth)+1;
			int monthDays = (int) ((365.25/12) * monthDifference);
			return monthDays;
		}else if(yearDifference ==1) {
			int yearDays = (int) (365.25 * yearDifference) + 1 ;//end date included
			return yearDays;
		}else { 
		int yearDays = (int) (365.25 * yearDifference) ; //every 4 years is an leap year(365.25 days)
		int totalMonth = toMonth-fromMonth;
		int totalDate =  (toDate - fromDate)+ 1;//end date included
//		int year = totalMonth/12;
//		int month= totalMonth%12;
		int monthDays = (int) ((365.25/12) * totalMonth);
		int totalDays = (yearDays + monthDays + totalDate) + 1;//for approx
		return totalDays;
		}
	}

}
