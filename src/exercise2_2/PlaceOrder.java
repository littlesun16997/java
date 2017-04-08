package exercise2_2;

import java.util.Locale;
import java.util.Scanner;

public class PlaceOrder {
	
	public void process() {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);
        System.out.println("How many order rows?");
        int number = sc.nextInt();
        double sum = 0;
        Order[] ord = new Order[number]; //array allocation
        
        for(int i = 0; i < number; i++){
            sc.nextLine(); //skip the line break
            
            ord[i] = new Order(); //object creation
            System.out.print("Name of the product?");
            ord[i].setName(sc.nextLine());
            System.out.print("Price?");
            ord[i].setPrice(sc.nextDouble());
            System.out.print("Quantity?");
            ord[i].setQuantity(sc.nextInt());		
        }
        
        System.out.println("Order rows");
        System.out.println("Name \tPrice \tQuantity \tTotal price");
        for(int i = 0; i < number; i++){
            System.out.println(ord[i].getName() + "\t" + ord[i].getPrice() + "\t" + ord[i].getQuantity() + "\t\t" + ord[i].orderPrice());
            sum += ord[i].orderPrice();
        }	
        System.out.println("Total price of the whole order is: " + sum);
    	sc.close();
    } 

	public static void main(String[] args) {
		Order ord = new Order();
		ord.setName("Table");
		ord.setPrice(48.65);
		ord.setQuantity(10);
		
		System.out.println("Product data:");
		System.out.println("Name: " + ord.getName());
		System.out.println("Price: " + ord.getPrice());
		System.out.println("Quantity: " + ord.getQuantity());
		System.out.println("Price of the order: " + ord.orderPrice());
		
		PlaceOrder ord2 = new PlaceOrder();
		ord2.process();
	}

}
