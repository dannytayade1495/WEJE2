package com.jspiders.multithreading.main;

import com.jspiders.multithreading.threads.MyThread1;
import com.jspiders.multithreading.threads.MyThread2;

public class MyThreadMain {

	public static void main(String[] args) {
		MyThread1 myThread1 = new MyThread1();
		myThread1.setName("Thread 1");
		myThread1.setPriority(6);
		MyThread2 myThread2 = new MyThread2();
		Thread thread = new Thread(myThread2);
		thread.setName("Thread 2");
		thread.setPriority(8);
		thread.start();
		myThread1.start();

	}

}
