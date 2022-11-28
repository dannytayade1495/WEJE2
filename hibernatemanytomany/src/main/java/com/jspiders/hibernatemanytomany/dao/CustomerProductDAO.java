package com.jspiders.hibernatemanytomany.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.TransactionException;

import com.jspiders.hibernatemanytomany.dto.CustomerDTO;
import com.jspiders.hibernatemanytomany.dto.ProductDTO;

public class CustomerProductDAO {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;

	private static void openConnections() {
		factory = Persistence.
				createEntityManagerFactory("ManyToMany");
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
			
			CustomerDTO customer1 = new CustomerDTO();
			customer1.setId(1);
			customer1.setName("Virat");
			customer1.setEmail("virat@bcci.com");
			customer1.setContact(9876543210L);
			
			CustomerDTO customer2 = new CustomerDTO();
			customer2.setId(2);
			customer2.setName("Messi");
			customer2.setEmail("messi@fifa.com");
			customer2.setContact(8796543210L);
			
			CustomerDTO customer3 = new CustomerDTO();
			customer3.setId(3);
			customer3.setName("Mary Kom");
			customer3.setEmail("mary@bfi.com");
			customer3.setContact(7986543210L);
			
			ProductDTO product1 = new ProductDTO();
			product1.setId(1);
			product1.setName("Shoes");
			product1.setPrice(80000.00);
			product1.setCategory("Sports");
			
			ProductDTO product2 = new ProductDTO();
			product2.setId(2);
			product2.setName("T-Shirt");
			product2.setPrice(999.99);
			product2.setCategory("Clothing");
			
			ProductDTO product3 = new ProductDTO();
			product3.setId(3);
			product3.setName("Watch");
			product3.setPrice(5000.00);
			product3.setCategory("Accessories");
			
			List<ProductDTO> products = 
					Arrays.asList(product1, product2, 
							product3);
			
			customer1.setProducts(products);
			customer2.setProducts(products);
			customer3.setProducts(products);
			
//			List<CustomerDTO> customers = 
//					Arrays.asList(customer1, customer2,
//							customer3);
//			
//			product1.setCustomers(customers);
//			product2.setCustomers(customers);
//			product3.setCustomers(customers);
			
			manager.persist(product1);
			manager.persist(product2);
			manager.persist(product3);
			manager.persist(customer1);
			manager.persist(customer2);
			manager.persist(customer3);
			
			transaction.commit();
			
		} finally {
			closeConnections();
		}
		
	}

}
