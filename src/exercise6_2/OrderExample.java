package exercise6_2;

import java.util.HashMap;
import java.util.Scanner;
import exercise2_2.Order;

public class OrderExample {

	public static void main(String[] args) {
		HashMap<Integer, Orders> product = new HashMap<>(); 
		
		Orders order = new Orders(1, "Ann", "25.01.2017");
		Order ord = new Order("TV", 120.12, 3);
		Order ord1 = new Order("Telephone", 36.52, 10);
		order.addOrd(ord);
		order.addOrd(ord1);
		
		Orders order2 = new Orders(2, "Bao", "16.01.2016");
		Order ord2 = new Order("PC", 500.25, 5);
		order2.addOrd(ord2);
		
		product.put(order.getOrderNum(), order);
		product.put(order2.getOrderNum(), order2);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("How many times do you want to print?");
		int time = sc.nextInt();
		
		for (int i = 0; i < time; i++) {
			System.out.println("Give an order number:");
			int j = sc.nextInt();
			if (product.containsKey(j)) {
				product.get(j).ordData();
			}
		}
		sc.close();
	}
}
