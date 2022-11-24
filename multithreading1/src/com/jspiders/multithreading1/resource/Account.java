package com.jspiders.multithreading1.resource;

public class Account {

	double accountBalance;

	public Account(double accountBalance) {
		super();
		this.accountBalance = accountBalance;
	}

	public void checkBalance() {
		System.out.println(accountBalance);
	}

	public synchronized void deposit(double amount) {
		accountBalance += amount;
		checkBalance();
	}

	public synchronized void withdraw(double amount) {
		if (accountBalance >= amount) {
			accountBalance -= amount;
			checkBalance();
		} else {
			System.out.println("Insufficient Balance.");
		}
	}

}
