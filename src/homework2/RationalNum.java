package homework2;

import java.util.Scanner;

public class RationalNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Give one rational number: ");
		String rat1 = sc.nextLine();
		System.out.println("Give another rational number: ");
		String rat2 = sc.nextLine();
		String[] part1 = rat1.split("\\/");
		String[] part2 = rat2.split("\\/");
		
		int num1, den1, num2, den2;
		num1 = Integer.parseInt(part1[0]);
		num2 = Integer.parseInt(part2[0]);
		den1 = Integer.parseInt(part1[1]);
		den2 = Integer.parseInt(part2[1]);
		
		Rational rat_num1 = new Rational(num1, den1);
		Rational rat_num2 = new Rational(num2, den2);
		
		System.out.println("Rational number 1: " + rat_num1.display() + " = " + rat_num1.decimal());
		System.out.println("Rational number 2: " + rat_num2.display() + " = " + rat_num2.decimal());
		System.out.println("Result: " + rat_num1.multiply(rat_num2).display() + " = " + rat_num1.multiply(rat_num2).decimal());
		
		sc.close();
	}
}
