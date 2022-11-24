package com.jspiders.adapterpattern.adapter;

import com.jspiders.adapterpattern.interfaces.CompanyEvents;
import com.jspiders.adapterpattern.objects.Employee;

public class CompEmpAdapter extends Employee 
implements CompanyEvents {

	public static void main(String[] args) {
		CompEmpAdapter adapter = new CompEmpAdapter();
		adapter.womensDay();
	}

	@Override
	public void womensDay() {

		CompEmpAdapter adapter = new CompEmpAdapter();
		adapter.setId(1);
		adapter.setName("Ambadas");
		adapter.setEmail("hapus143@gmail.com");

		System.out.println("The manager of the event is: " 
		+ adapter.getName());

		CompEmpAdapter adapter1 = new CompEmpAdapter();
		adapter1.setId(2);
		adapter1.setName("Chandra");
		adapter1.setEmail("chandra420@gmail.com");

		System.out.println("The chief guest of the "
				+ "event is: " + adapter1.getName());

	}

}