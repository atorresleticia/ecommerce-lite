//package main;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import model.Product;
//import model.User;
//
//public class Main {
//		
//	public static void main(String[] args) {
//				
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
//		EntityManager entityManager = factory.createEntityManager();
//				
//		System.out.println("Starting...");
//		
//		entityManager.getTransaction().begin();
//		
//		Product product = new Product();
//		
//		product.setName("Redes de Computadores e a Internet");
//		product.setDescription("Redes de computadores e a Internet tem como foco camadas de aplicação e interfaces de programação, propondo ao leitor uma experiência prática com os conceitos de protocolo e redes de computadores");
//		product.setImgPath("src\\main\\webapp\\lib\\redes.jpg");
//		product.setPrice(132.00f);
//		
//		entityManager.persist(product);
//		entityManager.getTransaction().commit();
//		
//		System.out.println("Product id = " + product.getId());
//		
//		@SuppressWarnings("unchecked")
//		List<Product> products = entityManager.createQuery("SELECT p FROM Product p").getResultList();
//		
//		for(Product p : products) {
//			System.out.println(p.toString());
//		}
//		
//		entityManager.close();
//		factory.close();
//		
//	}
//
//}
