package exercise4_2;

import java.util.ArrayList;

public class BankAccount {

	public static void main(String[] args) {
		Account.setInterest(3.9);
		ArrayList<Account> account = new ArrayList<Account>();
		Account acc1 = new Account(1, "Ann");
		account.add(acc1);
		Account acc2 = new Account(2, "Bob");
		account.add(acc2);
		Account acc3 = new Account(3, "Mark");
		account.add(acc3);
		acc1.deposit(1200);
		acc2.deposit(2500);
		acc3.deposit(4720);
		acc1.withdraw(40);
		acc3.withdraw(150);
		acc2.interest();
		
		for (Account acc:account) {
			System.out.println(acc.toString());
			System.out.println();
		}
		
		Account.transaction();
	}

}
