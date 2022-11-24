package com.jspiders.filehandling.files;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {

	public static void main(String[] args) {
		File file = new File("D:\\FileHandling\\DemoFile.txt");
		try {
			if (file.exists()) {
				System.out.println
				("The file already exists");
			} else {
				file.createNewFile();
				System.out.println
				("File created successfully");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
