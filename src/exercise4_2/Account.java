package exercise4_2;

import java.util.ArrayList;

public class Account {
	private int num;
	private String name;
	private double balance;
	private static double interest;
	private static ArrayList<String> transaction = new ArrayList<String>();
	
	public Account(int num, String name) {
		this.num = num;
		this.name = name;
		String open = "New account " + num + " by customer " + name;
		transaction.add(open);
	}
	
	public void deposit(double add) {
		this.balance = balance + add;
		String dep = "Account " + num + ": deposit " + add + " euro";
		transaction.add(dep);
	}
	
	public void withdraw(double subtract) {
		this.balance = balance - subtract;
		String wit = "Account " + num + ": withdraw " + subtract + " euro";
		transaction.add(wit);
	}
	
	public void interest() {
		this.balance = balance + balance*interest/100;
		String int_rate = "Account " + num + ": interest " + interest + " %";
		transaction.add(int_rate);
	}
	
	public String toString() {
		String description = "Account number: " + this.num + "\nCustomer name: " + this.name + "\nBalance: " + this.balance;
		return description;
	}

	public static void setInterest(double interest) {
		Account.interest = interest;
	}
	
	public static void transaction() {
		for (String trans: transaction) {
			System.out.println(trans);
		}
	}
}
