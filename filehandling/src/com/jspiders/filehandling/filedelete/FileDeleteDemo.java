package com.jspiders.filehandling.filedelete;

import java.io.File;
import java.io.IOException;

public class FileDeleteDemo {

	public static void main(String[] args) {
		File file = new File("DemoFile.c");
		try {
			file.createNewFile();
			System.out.println("File created");
		} catch (IOException e) {
			e.printStackTrace();
		}
//		file.delete();
//		System.out.println("File deleted");
	}
}
