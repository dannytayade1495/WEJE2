package com.jspiders.designpatternstask.objects;

public class CheckBalance {

	private Account account;

	public CheckBalance(Account account) {
		this.account = account;
	}

	public void checkBalance() {
		System.out.println("Current balance: " 
	+ account.accountBalance);
	}

}
