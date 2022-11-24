package com.jspiders.builderpattern.object;

public class Mobile {
	
	private String brand;
	private String model;
	private String color;
	private double price;
	private int ram;
	private int memory;
	private String os;
	private int f_cam;
	private int r_cam;
	private int disp_size;
	
	public Mobile(String brand, String model, 
			String color, double price,	int ram,
			int memory, String os, int f_cam,
			int r_cam, int disp_size) {
		super();
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.price = price;
		this.ram = ram;
		this.memory = memory;
		this.os = os;
		this.f_cam = f_cam;
		this.r_cam = r_cam;
		this.disp_size = disp_size;
	}

	@Override
	public String toString() {
		return "Mobile [brand=" + brand 
				+ ", model=" + model + ", color=" + color 
				+ ", price=" + price + ", ram=" + ram
				+ ", memory=" + memory + ", os=" + os 
				+ ", f_cam=" + f_cam + ", r_cam=" + r_cam 
				+ ", disp_size=" + disp_size + "]";
	}
	
}