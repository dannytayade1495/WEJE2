package com.jspiders.factorypattern.movies;

import com.jspiders.factorypattern.inter.Movie;

public class Vikram implements Movie {

	@Override
	public void nowPlaying() {
		System.out.println("Now playing Vikram");
	}

}
