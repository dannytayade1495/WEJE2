package com.jspiders.singleton.main;

import com.jspiders.singleton.object.SingletonEager;

public class EagerMain {
	
	public static void main(String[] args) {
		SingletonEager.getObject();
		SingletonEager.getObject();
		SingletonEager.getObject();
		SingletonEager.getObject();
		SingletonEager.getObject();
	}

}
