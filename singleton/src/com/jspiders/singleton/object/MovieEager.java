package com.jspiders.singleton.object;

public class MovieEager {
	static int noOfTickets;
	
	static MovieEager movieEager= new MovieEager(100);
	
	public MovieEager(int noOfTickets) {
		this.noOfTickets=noOfTickets;
	}
	
	public static  MovieEager bookTickets(int noOfBooking){
		System.out.println("Available ticktes: "+noOfTickets);
		System.out.println("Booking "+noOfBooking+" tickets");
		
		if(noOfBooking>noOfTickets) {
			System.out.println("Tickets not available..");
			return movieEager;
		}
		noOfTickets-=noOfBooking;
		System.out.println("Tickets left: "+noOfTickets);
		return movieEager;
		 
	}
}
