package com.jspiders.multithreading1.threads;

import com.jspiders.multithreading1.resource.Account;

public class Wife extends Thread {

	Account account;

	public Wife(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		account.deposit(1500);
		account.withdraw(1500);
	}

}
