package com.jspiders.filehandling.readwrite;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharacterFile {

	public static void main(String[] args) {
		File file = new File("CharStream.txt");
		try {
			if (file.exists()) {
				System.out.println("File exists");
			} else {
				file.setReadable(true);
				file.setWritable(true);
				file.createNewFile();
				System.out.println("File created");
			}
			
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write
			("This is the data sent to the file");
			System.out.println
			("Content written to file");
			fileWriter.close();

			FileReader fileReader = new FileReader(file);
			System.out.println(fileReader.read());
			System.out.println
			("Content read from file");
			fileReader.close();
			
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
