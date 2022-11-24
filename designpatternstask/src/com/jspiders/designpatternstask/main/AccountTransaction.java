package com.jspiders.designpatternstask.main;

import java.util.Scanner;

import com.jspiders.designpatternstask.objects.Account;
import com.jspiders.designpatternstask.objects.CheckBalance;
import com.jspiders.designpatternstask.objects.Deposit;
import com.jspiders.designpatternstask.objects.Withdraw;

public class AccountTransaction {
	static Scanner scanner = new Scanner(System.in);
	static boolean loop = true;

	public static void main(String[] args) {

		while (loop) {
			transactions();
		}
		scanner.close();
	}

	private static void transactions() {
		System.out.println("Choose transaction"
				+ "\n1. Deposit\n2. Withdraw"
				+ "\n3. Check Balance\n4. Exit");

		int choice = scanner.nextInt();
		int amount = 0;
		switch (choice) {
		case 1:
			Account accountDeposit = Account.getAccount();
			System.out.println("Enter amount to deposit: ");
			amount = scanner.nextInt();
			Deposit deposit = 
					new Deposit(accountDeposit, amount);
			deposit.deposit();
			break;

		case 2:
			Account accountWithdraw = Account.getAccount();
			System.out.println("Enter amount to withdraw: ");
			amount = scanner.nextInt();
			Withdraw withdraw = 
					new Withdraw(accountWithdraw, amount);
			withdraw.withdraw();
			break;

		case 3:
			Account accountCheck = Account.getAccount();
			CheckBalance balance = 
					new CheckBalance(accountCheck);
			balance.checkBalance();
			break;

		case 4:
			System.out.println("Thank you");
			loop = false;
			break;

		default:
			System.out.println("Invalid choice");
			break;
		}
	}

}
