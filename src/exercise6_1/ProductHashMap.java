package exercise6_1;

import java.util.HashMap;
import java.util.Scanner;

public class ProductHashMap {

	public static void main(String[] args) {
		HashMap<Integer, Double> product = new HashMap<>(); 
		product.put(1, 12.5);
		product.put(2, 52.46);
		product.put(3, 25.87);
		product.put(4, 63.21);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("How many times do you want to print?");
		int time = sc.nextInt();
		
		for (int i = 0; i < time; i++) {
			System.out.println("Choose a product number from 1, 2, 3, 4:");
			int key = sc.nextInt();
			System.out.println("Product " + key + " has price " + product.get(key));
		}
		sc.close();
	}
}
