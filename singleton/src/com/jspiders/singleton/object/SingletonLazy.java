package com.jspiders.singleton.object;

public class SingletonLazy {

	static SingletonLazy singletonLazy;
	int objectCount;
	
	private SingletonLazy() {
		objectCount++;
		System.out.println("Object created " 
		+ objectCount + " times");
	}
	
	public static SingletonLazy getObject() {
		if (singletonLazy == null) {
			singletonLazy = new SingletonLazy();
			return singletonLazy;
		}
		return singletonLazy;
	} 
	
}