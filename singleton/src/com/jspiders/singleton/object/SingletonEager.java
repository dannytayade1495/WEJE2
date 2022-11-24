package com.jspiders.singleton.object;

public class SingletonEager {
	
	static int objectCount;
	
	static SingletonEager singletonEager = 
			new SingletonEager();

	private SingletonEager() {
		objectCount++;
	}
	
	public static SingletonEager getObject() {
		System.out.println("Object created "
				+ objectCount + " times");
		return singletonEager;
	}
}