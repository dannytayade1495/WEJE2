package com.jspiders.hibernateonetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.TransactionException;

import com.jspiders.hibernateonetoone.dto.HusbandDTO;
import com.jspiders.hibernateonetoone.dto.WifeDTO;

public class HusbandWifeDAO {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("OneToOne");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		try {
			transaction.rollback();
		} catch (TransactionException e) {
			System.out.println("Transaction is committed.");
		}
	}
	
	public static void main(String[] args) {
		
		try {
			openConnection();
			
			transaction.begin();
			
			WifeDTO wife = new WifeDTO();
			wife.setId(1);
			wife.setName("Anjali");
			wife.setEmail("anjali@kkhh.com");
			wife.setAge(26);
			wife.setContact(9876543210L);
			
			HusbandDTO husband = new HusbandDTO();
			husband.setId(1);
			husband.setName("Rahul");
			husband.setEmail("rahul@kkhh.com");
			husband.setAge(27);
			husband.setContact(8796543210L);
			
			husband.setWife(wife);
			wife.setHusband(husband);
			
			manager.persist(husband);
			manager.persist(wife);
			
			transaction.commit();
			
		} finally {
			closeConnection();
		}
		
	}

}
