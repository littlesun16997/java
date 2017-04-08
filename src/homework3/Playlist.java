package homework3;

import java.util.ArrayList;
import java.util.Scanner;

public class Playlist {

	public static void main(String[] args) {
		ArrayList<Music> track = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("How many tracks do you want to insert?");
		int time = sc.nextInt();
		String title, artist, duration;
		sc.nextLine();
		
		for (int i = 0; i < time; i++) {
			System.out.print("Title: ");
			title = sc.nextLine();
			System.out.print("Artist: ");
			artist = sc.nextLine();
			System.out.print("Duration: ");
			duration = sc.nextLine();
			track.add(new Music(title, artist, duration));
		}
		System.out.println("Do you want to move your tracks?");
		// Type 'y' for yes
		if (sc.nextLine().equalsIgnoreCase("y")) {
			System.out.println("Which track number do you want to move?");
			// choose a track from 1,2,3,4,...
			int num = sc.nextInt();
			System.out.println("To which position do you want to move?");
			// choose a place from 1,2,3,4,...
			int index = sc.nextInt();
			
			// if you want to move a track down
			if (index > num) {
				track.add(index, track.get(num-1));
				track.remove(num-1);
			}
			// if you want to move a track up
			else {
				track.add(index-1, track.get(num-1));
				track.remove(num);
			}
		}
		System.out.println("\nPlaylist data: ");
		for (int i = 0; i < track.size(); i++) {
			System.out.println("Track " + (i + 1));
			track.get(i).print();
			System.out.println("");
		}
		sc.close();
	}
}
