package com.jspiders.multithreading1.main;

import com.jspiders.multithreading1.resource.Account;
import com.jspiders.multithreading1.threads.Husband;
import com.jspiders.multithreading1.threads.Wife;

public class AccountMain {

	public static void main(String[] args) {

		Account account = new Account(5000);
		Husband husband = new Husband(account);
		Wife wife = new Wife(account);
		husband.start();
		wife.start();

	}

}
