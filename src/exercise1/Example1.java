package exercise1;

import java.util.Scanner;

public class Example1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Your name?");
		String name = input.nextLine();
		System.out.println("Hello " + name);
		input.close();
	}
}
