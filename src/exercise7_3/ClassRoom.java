package exercise7_3;

import java.util.Scanner;

public class ClassRoom extends Room{
	private int seats, computers;
	private boolean dataProjector;
	
	public int getSeats() {
		return seats;
	}
	public int getComputers() {
		return computers;
	}
	public boolean isDataProjector() {
		return dataProjector;
	}
	public void askData() {
		super.askData();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("How many seats?");
		this.seats = sc.nextInt();
		System.out.println("How many computers?");
		this.computers = sc.nextInt();
		System.out.println("Does it have a data projector? (Answer by true or false)");
		this.dataProjector = sc.nextBoolean();
	}
	public String toString() {
		StringBuilder classroom = new StringBuilder();
		classroom.append(super.toString());
		classroom.append(", seats " + seats + ", computers " + computers);
		if (dataProjector == true) {
			classroom.append(", data projector");
		}
		return classroom.toString();
	}
}
