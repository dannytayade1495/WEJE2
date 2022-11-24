package com.jspiders.singleton.main;

import com.jspiders.singleton.object.MovieLazy;

public class MovieLazyMain {
	
	public static void main(String[] args) {
		MovieLazy.bookTickets(20);
		MovieLazy.bookTickets(50);
		MovieLazy.bookTickets(40);
	}

}
