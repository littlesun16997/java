package exercise5_1;

import java.util.Scanner;

import homework1.Dice;

public class DiceRoll {

	public static void main(String[] args) {
		Dice dice = new Dice();
		Distribution dis = new Distribution(1,6);
		Printing print = new Printing(dis);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("How many times do you want to roll?");
		int time = sc.nextInt();
		for (int i = 0; i < time; i++) {
			dice.setScore(dice.rollDice());
			dis.insert(dice.getScore());
		}
		print.print();
		sc.close();
	}
}
