package com.jspiders.multithreadingwaitandnotify.threads;

import com.jspiders.multithreadingwaitandnotify.resource.Pizza;

public class Friends extends Thread {

	Pizza pizza;

	public Friends(Pizza pizza) {
		super();
		this.pizza = pizza;
	}

	@Override
	public void run() {
		pizza.orderPizza(50);
	}
}
