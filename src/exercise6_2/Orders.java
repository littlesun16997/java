package exercise6_2;

import java.util.ArrayList;
import exercise2_2.Order;

public class Orders {
	private int orderNum;
	private String customerName;
	private String date;
	private ArrayList<Order> ordRow = new ArrayList<>();
	
	public Orders(int orderNum, String customerName, String date) {
		this.orderNum = orderNum;
		this.customerName = customerName;
		this.date = date;
	}
	
	public int getOrderNum() {
		return orderNum;
	}

	public void addOrd(Order ord) {
		ordRow.add(ord);
	}
	public double price() {
		double sum = 0;
		for (int i = 0; i < ordRow.size(); i++) {
			sum += ordRow.get(i).orderPrice();
		}
		return sum;
	}
	public void ordData() {
		StringBuilder data = new StringBuilder();
		data.append("Order number: " + orderNum + "\n");
		data.append("Customer name: " + customerName + "\n");
		data.append("Order date: " + date + "\n");
		
		for (int i = 0; i < ordRow.size(); i++) {
			data.append("Order row: " + ordRow.get(i).getQuantity() + " " + ordRow.get(i).getName() + " " + ordRow.get(i).getPrice() + " each\n");
		}
		data.append("Total price: " + price() + "\n");
		String order = data.toString();
		System.out.println(order);
	}
}
