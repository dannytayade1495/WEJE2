package com.jspiders.multithreadingwaitandnotify.threads;

import com.jspiders.multithreadingwaitandnotify.resource.Pizza;

public class Cafe extends Thread {

	Pizza pizza;

	public Cafe(Pizza pizza) {
		super();
		this.pizza = pizza;
	}

	@Override
	public void run() {
		pizza.bakePizza(30);
	}

}
