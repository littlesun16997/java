package exercise2_3;

import java.util.Scanner;

public class DateString {

	public static void main(String[] args) {
		Date date1 = new Date();
		date1.setDay(13);
		date1.setMonth(01);
		date1.setYear(2017);
		System.out.println(date1.toString());
		
		Date now = new Date();
		
		Date time = new Date("16.01.2017");
		System.out.print(time.getDay());
		System.out.print("." + time.getMonth());
		System.out.print("." + time.getYear());
		System.out.println();
		System.out.println("Month name to number: " + Date.month("SEPTEMBER"));
		
		Scanner sc = new Scanner(System.in);
		System.out.println("What date (dd.mm.yyyy)?");
		String date = sc.nextLine();
		Date user = new Date(date);
		System.out.print(user.getDay());
		System.out.print("." + user.getMonth());
		System.out.print("." + user.getYear());
		System.out.println();
		System.out.println(user.date());
		System.out.println("Compare the date user gave with today: " + user.equals(now));
		
		sc.close();
	}

}
