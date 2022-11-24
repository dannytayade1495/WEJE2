package com.jspiders.filehandling.readwrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteFile {

	public static void main(String[] args) {
		File file = new File("ByteStream.txt");
		if (file.exists()) {
			System.out.println("File exists");
		} else {
			try {
				file.setReadable(true);
				file.setWritable(true);
				file.createNewFile();

				System.out.println("File created");

				FileOutputStream opStream = 
						new FileOutputStream(file);
				opStream.write(45);
				System.out.println
				("Content written to file");
				opStream.close();
				
				FileInputStream ipStream = 
						new FileInputStream(file);
				System.out.println(ipStream.read());
				System.out.println
				("Data read from file");
				ipStream.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
