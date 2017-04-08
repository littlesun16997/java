package exercise7_3;

import java.util.Scanner;

public class Room {
	private String num, description;
	
	public void askData() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Give room number: ");
		num = sc.nextLine();
		System.out.print("Give room description: ");
		description = sc.nextLine();
	}
	
	public String toString() {
		return (num.toUpperCase() + " " + description);
	}

	public String getNum() {
		return num;
	}

}
