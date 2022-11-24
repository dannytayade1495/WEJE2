package com.jspiders.musicplayer;

import java.util.ArrayList;
import java.util.Scanner;

public class SongOperation {
	Scanner sc = new Scanner(System.in);
	ArrayList<Song> list = new ArrayList<Song>();

	public void addSong() {
		System.out.println("How any songs you want to add?");
		int addCount = sc.nextInt();
		for (int i = 0; i < addCount; i++) {
			Song song = new Song();
			System.out.println("Enter the Id for Song : ");
			song.setId(sc.nextInt());

			System.out.println("Enter the Name of Song : ");
			song.setSongName(sc.next());

			System.out.println("Enter the Singer Name : ");
			song.setSingerName(sc.next());

			System.out.println("Enter the Movie Name of the Song: ");
			song.setMovieName(sc.next());

			System.out.println("Enter the Name of the Composer : ");
			song.setLyrist(sc.next());

			System.out.println("Enter the Duration time of the song : ");
			song.setDuration(sc.nextDouble());

			list.add(song);
			System.out.println("Added "+song.songName +" Song Successfully");
		}
	}

	public void displayAllSongs() {
		if (list.isEmpty()) {
			System.out.println("Add songs then you will get SongsList..");
			addSong();
		}
		for (Song song : list) {
			System.out.println(song.getSongName());
		}
	}

	public void removeSong() {
		if (list.isEmpty()) {
			System.out.println("Add songs then Remove..");
			addSong();
		}
		System.out.println("Select song to Remove ");
		displayAllSongs();
		int removeId = sc.nextInt();
		System.out.println(list.get(removeId - 1).getSongName() + " removed Successfully...");
		list.remove(removeId - 1);
		displayAllSongs();
	}

	public void updateSong() {
		if (list.isEmpty()) {
			System.out.println("Add songs then Update..");
			addSong();
		}
		System.out.println("Select song to Update ");
		displayAllSongs();
		int update = sc.nextInt();
		list.remove(update - 1);
		Song song1 = new Song();

		System.out.println("Enter the Id for Song : ");
		song1.setId(sc.nextInt());

		System.out.println("Enter the Name of Song : ");
		song1.setSongName(sc.next());

		System.out.println("Enter the Singer Name : ");
		song1.setSingerName(sc.next());

		System.out.println("Enter the Movie Name of the Son : ");
		song1.setMovieName(sc.next());

		System.out.println("Enter the Name of the Composer : ");
		song1.setComposer(sc.next());

		System.out.println("Enter the Name of the Lyrist : ");
		song1.setLyrist(sc.next());

		System.out.println("Enter the Duration time of te song : ");
		double duration = sc.nextDouble();
		song1.setDuration(duration);

		list.add(update - 1, song1);
		System.out.println(list.get(update-1).getSongName()+" Updated Song details Successfully");
	}

	public void chooseToPlay() {
		if (list.isEmpty()) {
			System.out.println("Add songs then play..");
			addSong();
		}
		System.out.println("Select song to Play ");
		displayAllSongs();
		int play = sc.nextInt();
		System.out.println("Playing song " + list.get(play - 1).getSongName());
	}

	public void playAllSongs() {
		if (list.isEmpty()) {
			System.out.println("Add songs then play..");
			addSong();
		}
		System.out.println("Playing All songs ");
		for (Song song : list) {
			System.out.println(song.getSongName());
		}
	}

	public void playRandomSong() {
		if (list.isEmpty()) {
			System.out.println("Add songs then play..");
			addSong();
		}
		System.out.println("Playing Random songs ");
		double number = Math.random();
		int random = (int) (number * 10) + 1;
		if (random>list.size()) {
			random=0;
		}
		System.out.println("Playing song " + list.get(random).getSongName());
	}

}
