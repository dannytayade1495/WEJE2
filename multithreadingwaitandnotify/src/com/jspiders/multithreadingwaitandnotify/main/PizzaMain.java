package com.jspiders.multithreadingwaitandnotify.main;

import com.jspiders.multithreadingwaitandnotify.resource.Pizza;
import com.jspiders.multithreadingwaitandnotify.threads.Cafe;
import com.jspiders.multithreadingwaitandnotify.threads.Friends;

public class PizzaMain {

	public static void main(String[] args) {
		Pizza pizza = new Pizza(30);
		Friends friends = new Friends(pizza);
		Cafe cafe = new Cafe(pizza);
		friends.start();
		cafe.start();
	}

}
