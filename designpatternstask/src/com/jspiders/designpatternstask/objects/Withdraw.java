package com.jspiders.designpatternstask.objects;

public class Withdraw {

	private Account account;
	private int withdrawAmount;

	public Withdraw(Account account, int amount) {
		this.account = account;
		this.withdrawAmount = amount;
	}

	public void withdraw() {
		if (withdrawAmount > account.accountBalance) {
			System.out.println("Insufficient account balance");
		} else {
			account.accountBalance -= withdrawAmount;
			System.out.println("Withdrawn " + withdrawAmount + " rupees");
			CheckBalance balance = new CheckBalance(account);
			balance.checkBalance();
		}
	}

}
