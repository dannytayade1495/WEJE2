package com.jspiders.springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.TransactionException;
import org.springframework.stereotype.Repository;

import com.jspiders.springmvc.pojo.StudentPOJO;

@Repository
public class StudentRepository {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	private static String jpql;

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("student");
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
		if (transaction != null) {
			try {
				transaction.rollback();
			} catch (TransactionException e) {
				System.out.println("transaction already committed");
			}
		}
	}

	public StudentPOJO login(String username, String password) {
		openConnection();
		transaction.begin();
		jpql = "from StudentPOJO " + "where username = '" + username + "' " + "and password ='" + password + "'";
		query = manager.createQuery(jpql);
		List<StudentPOJO> list = (List<StudentPOJO>) query.getResultList();
		transaction.commit();
		closeConnection();
		for (StudentPOJO pojo : list) {
			return pojo;
		}
		return null;
	}

	public StudentPOJO add(String name, String email, long contact, String city, String username, String password) {
		openConnection();
		transaction.begin();
		StudentPOJO pojo = new StudentPOJO();
		pojo.setName(name);
		pojo.setEmail(email);
		pojo.setContact(contact);
		pojo.setCity(city);
		pojo.setUsername(username);
		pojo.setPassword(password);
		manager.persist(pojo);
		transaction.commit();
		closeConnection();
		return pojo;
	}

	public StudentPOJO search(int id) {
		openConnection();
		transaction.begin();
		StudentPOJO pojo = manager.find(StudentPOJO.class, id);
		transaction.commit();
		closeConnection();
		return pojo;
	}

	public List<StudentPOJO> searchAll() {
		openConnection();
		transaction.begin();
		jpql = "from StudentPOJO";
		query = manager.createQuery(jpql);
		List<StudentPOJO> pojos = query.getResultList();
		transaction.commit();
		closeConnection();
		return pojos;
	}

	public StudentPOJO remove(int id) {
		openConnection();
		transaction.begin();
		StudentPOJO pojo = manager.find(StudentPOJO.class, id);
		if (pojo != null) {
			manager.remove(pojo);
		}
		transaction.commit();
		closeConnection();
		return pojo;
	}

	public void update(int id, String name, String email, long contact, String city, String username, String password) {
		openConnection();
		transaction.begin();
		StudentPOJO pojo = manager.find(StudentPOJO.class, id);
		pojo.setName(name);
		pojo.setEmail(email);
		pojo.setContact(contact);
		pojo.setCity(city);
		pojo.setUsername(username);
		pojo.setPassword(password);
		manager.persist(pojo);
		transaction.commit();
		closeConnection();
	}

}
