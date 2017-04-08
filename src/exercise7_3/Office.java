package exercise7_3;

import java.util.ArrayList;
import java.util.Scanner;

public class Office extends Room {
	ArrayList<String> staff = new ArrayList<>();
	
	public void askData() {
		super.askData();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("How many staff members?");
		int number = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < number; i++) {
			System.out.println("Give name: ");
			staff.add(sc.nextLine());
		}
	}
	
	public String toString() {
		StringBuilder print = new StringBuilder();
		print.append(super.toString());
		print.append("\nStaff members: ");
		for (int i = 0; i < staff.size(); i++) {
			print.append(staff.get(i) + "\t"); 
		}
		return print.toString();
	}
	
	public boolean worksHere(String name) {
		boolean result = false;
		for (int i = 0; i < staff.size(); i++) {
			if (name.equalsIgnoreCase(staff.get(i))) {
				result = true;
			}
			else {
				result = false;
			}
		}
		return result;
	}
}
