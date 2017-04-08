package exercise7_3;

import java.util.ArrayList;
import java.util.Scanner;

public class RoomObject {

	public static void main(String[] args) {
		ArrayList<Room> rooms = new ArrayList<>();
		System.out.println("Room program");
		System.out.println("1. Insert a room\n2. Print out all rooms\n3. Print out offices\n4. Print out class rooms");
		System.out.println("5. Print out other rooms (not office, not classroom)\n6. Search a room\n7. Search a staff member");
		System.out.println("8. Quit");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose an option");
		int opt = sc.nextInt();

		while (opt != 8) {
			switch (opt) {
			case 1:		// Insert a room
				System.out.println("Choose from O(office), C(classroom) and other rooms: ");
				String type = sc.next();
				
				if (type.equalsIgnoreCase("o")) {
					Office o1 = new Office();
					o1.askData();
					rooms.add(o1);
				}
				else if (type.equalsIgnoreCase("c")) {
					ClassRoom c1 = new ClassRoom();
					c1.askData();
					rooms.add(c1);
				}
				else {
					Room r1 = new Room();
					r1.askData();
					rooms.add(r1);
				}
				break;
			case 2:		// Print all rooms
				for (int i = 0; i < rooms.size(); i++) {
					System.out.println(rooms.get(i).toString());
				}
				break;
			case 3:		// Print offices
				for (int i = 0; i < rooms.size(); i++) {
					if (rooms.get(i) instanceof Office) {
						System.out.println(rooms.get(i).toString());
					}
				}
				break;
			case 4:		// Print classrooms
				for (int i = 0; i < rooms.size(); i++) {
					if (rooms.get(i) instanceof ClassRoom) {
						System.out.println(rooms.get(i).toString());
					}
				}
				break;
			case 5:		// Print other rooms
				for (int i = 0; i < rooms.size(); i++) {
					if (!(rooms.get(i) instanceof Office)
							&& !(rooms.get(i) instanceof ClassRoom)) {
						System.out.println(rooms.get(i).toString());
					}
				}
				break;
			case 6:		// Search a room
				sc.nextLine();
				System.out.println("Give a room number: ");
				String room = sc.nextLine();
				for (int i = 0; i < rooms.size(); i++) {
					if (room.equalsIgnoreCase(rooms.get(i).getNum())) {
						System.out.println(rooms.get(i).toString());
					}
				}
				break;
			case 7:		// Search a staff
				sc.nextLine();
				System.out.println("Give the name of the staff: ");
				String name = sc.nextLine();
				for (int i = 0; i < rooms.size(); i++) {
					if (rooms.get(i) instanceof Office) {
						if (((Office)rooms.get(i)).worksHere(name) == true) {
							System.out.println(rooms.get(i).toString());
						}
					}
				}
				break;
			case 8:		// Quit the program
				break;
			}
			System.out.println("\nChoose an option");
			opt = sc.nextInt();
		}
	}

}
