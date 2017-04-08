package exam1_1;

import java.util.Scanner;

public class BPobject {

	public static void main(String[] args) {
		BoardingPass bp1 = new BoardingPass();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Give flight number: ");
		bp1.setFlight(sc.nextLine());
		System.out.print("Give gate number: ");
		bp1.setGate(sc.nextInt());
		System.out.print("Give seat number: ");
		bp1.setSeat(sc.next());
		
		System.out.println("Flight: " + bp1.getFlight() + "\nGate: " + bp1.getGate() + "\nSeat: " + bp1.getSeat());
		System.out.println("Boarding group: " + bp1.group());
	}
}
