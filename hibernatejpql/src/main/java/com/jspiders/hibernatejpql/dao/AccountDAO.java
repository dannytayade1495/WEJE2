package com.jspiders.hibernatejpql.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.TransactionException;

import com.jspiders.hibernatejpql.dto.AccountDTO;

public class AccountDAO {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static String query;

	private static void openConnections() {
		factory = Persistence.
				createEntityManagerFactory("jpql");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private static void closeConnections() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction != null) {
			try {
				transaction.rollback();
			} catch (TransactionException e) {
				System.out.println
				("Transaction is committed.");
			}
		}
	}
	
	public static void main(String[] args) {
		
		try {
			
			openConnections();
			transaction.begin();
			
//			AccountDTO account1 = new AccountDTO();
//			account1.setAccountNo(1234567890L);
//			account1.setAccountHolder("Vijay Malya");
//			account1.setBank("Punjab National Bank");
//			account1.setBranch("Banergatta");
//			account1.setCity("Bangalore");
//			account1.setIfsc("PNB10002");
//			
//			AccountDTO account2 = new AccountDTO();
//			account2.setAccountNo(1765412398L);
//			account2.setAccountHolder("Harshad Mehta");
//			account2.setBank("State Bank of India");
//			account2.setBranch("Dharavi");
//			account2.setCity("Mumbai");
//			account2.setIfsc("SBI10002");
//			
//			AccountDTO account3 = new AccountDTO();
//			account3.setAccountNo(178734398L);
//			account3.setAccountHolder("Nirav Modi");
//			account3.setBank("Bank of Maharashtra");
//			account3.setBranch("Gandhinagar");
//			account3.setCity("Gujrat");
//			account3.setIfsc("MAHA10002");
//			
//			manager.persist(account1);
//			manager.persist(account2);
//			manager.persist(account3);
			
			query = "from AccountDTO "
					+ "where accountHolder like '%y%'";
			Query createQuery = manager.createQuery(query);
			List accounts = createQuery.getResultList();
			
			for (int i = 0; i < accounts.size(); i++) {
				System.out.println(accounts.get(i));
			}
			
			query = "update AccountDTO"
					+ " set bank = 'PNB'"
					+ " where id = 19";
			createQuery = manager.createQuery(query);
			int resultInt = createQuery.executeUpdate();
			System.out.println(resultInt 
					+ " row(s) affected");
			
			query = "delete from AccountDTO"
					+ " where id = 19";
			createQuery = manager.createQuery(query);
			resultInt = createQuery.executeUpdate();
			System.out.println(resultInt 
					+ " row(s) affected");
			
			transaction.commit();
			
		} finally {
			closeConnections();
		}
	}

}
