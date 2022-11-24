package com.jspiders.designpatternstask.objects;

public class Account {
	
	
	int accountBalance;
	static Account account = new Account(10000);

	private Account(int amount) {
		this.accountBalance = amount;
	}
	
	public static Account getAccount() {
		return account;
	}
}
