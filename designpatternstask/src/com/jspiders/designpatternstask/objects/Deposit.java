package com.jspiders.designpatternstask.objects;

public class Deposit {

	private Account account;
	private int depositAmount;

	public Deposit(Account account, int amount) {
		this.account = account;
		this.depositAmount = amount;
	}

	public void deposit() {
		account.accountBalance += depositAmount;
		System.out.println("Deposited " + depositAmount + " rupees");
		CheckBalance balance = new CheckBalance(account);
		balance.checkBalance();
	}
}
