package exercise5_1;

import java.util.Scanner;

public class GradeDistribution {

	public static void main(String[] args) {
		Distribution grade = new Distribution(0,5);
		Scanner sc = new Scanner(System.in);
		System.out.println("Give 5 grades: ");
		for (int i = 0; i < 5; i++) {
			int g1 = sc.nextInt();
			grade.insert(g1);
		}
		Printing print = new Printing(grade);
		print.print();
		sc.close();
	}

}
