package com.jspiders.serializationdeserialization.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.jspiders.serializationdeserialization.objects.User;

public class UserMain {

	public static void main(String[] args) {
		User user = new User(1, "Aditya", "aditya123");
		
		try {
			
			FileOutputStream fileOut =
					new FileOutputStream("D:\\file.txt");
			ObjectOutputStream objectOut =
					new ObjectOutputStream(fileOut);
			objectOut.writeObject(user);
			System.out.println("Object written");
			objectOut.flush();
			objectOut.close();
			
			FileInputStream fileIn =
					new FileInputStream("D:\\file.txt");
			ObjectInputStream objectIn = 
					new ObjectInputStream(fileIn);
			User readObject = (User) objectIn.readObject();
			System.out.println(readObject);
			objectIn.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
