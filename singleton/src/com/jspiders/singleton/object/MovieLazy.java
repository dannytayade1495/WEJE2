package com.jspiders.singleton.object;

public class MovieLazy {
	
	static int noOfTickets;
	
	static MovieLazy movieLazy;
	
	private MovieLazy(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}
	
	public static MovieLazy bookTickets(int noOfBookings) {
		if (movieLazy == null) {
			movieLazy = new MovieLazy(100);
		}
		System.out.println("Avialble tickets: "
				+noOfTickets);
		System.out.println("Booking "
				+ noOfBookings + " tickets");
		if (noOfBookings > noOfTickets) {
			System.out.println("Tickets not available");
			return movieLazy;
		}
		noOfTickets -= noOfBookings;
		System.out.println("Tickets left: "
				+noOfTickets);
		return movieLazy;
	}

}