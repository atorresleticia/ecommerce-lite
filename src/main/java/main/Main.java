package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.User;

public class Main {
		
	public static void main(String[] args) {
				
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = factory.createEntityManager();
		
		System.out.println("Starting...");
		
		entityManager.getTransaction().begin();
		
		User user = new User();
		user.setName("Torres");
		
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		
		System.out.println("User id = " + user.getId());
		
		List<User> users = entityManager.
				createQuery("SELECT u FROM User u").getResultList();
		
		for(User u : users) {
			System.out.println(u.toString());
		}
		
		entityManager.clear();
		factory.close();
		
	}

}
