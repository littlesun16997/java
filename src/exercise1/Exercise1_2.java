package exercise1;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise1_2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("How many values?");
		int size = input.nextInt();
		int[] values = new int[size];
		System.out.println("Values?");
		int i, sum = 0;
		for (i = 0; i < size; i++){
			values[i] = input.nextInt();
			sum += values[i];
		}
		System.out.println("Your values:");
		Arrays.sort(values);
		for (int num: values){
			System.out.println(num);
		}
		double ave;
		ave = (double)sum / size;
		System.out.println("Average: " + ave);
		input.close();
	}

}
