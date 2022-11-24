package com.jspiders.builderpattern.main;

import com.jspiders.builderpattern.builder.MobileBuilder;
import com.jspiders.builderpattern.object.Mobile;

public class MobileMain {
	
	public static void main(String[] args) {
		Mobile mobile = new MobileBuilder().price(50000.00)
				.model("S22").brand("Samsung").getMobile();
		System.out.println(mobile);
	}

}
