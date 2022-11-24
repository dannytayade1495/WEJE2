package com.jspiders.singleton.main;

import com.jspiders.singleton.object.SingletonLazy;

public class LazyMain {
	
	public static void main(String[] args) {
		SingletonLazy.getObject();
		SingletonLazy.getObject();
		SingletonLazy.getObject();
		SingletonLazy.getObject();
		SingletonLazy.getObject();
	}

}
