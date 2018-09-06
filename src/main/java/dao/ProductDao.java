package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Product;

public class ProductDao {
	
	private static String SELECT_PRODUCTS_QUERY = "SELECT p FROM Product p";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
	private static EntityManager entityManager = factory.createEntityManager();
	
	public static Product getProductById(Long id) {
		Product product = entityManager.find(Product.class, id);
		return product;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Product> getProducts(){
		List<Product> products = entityManager.createQuery(SELECT_PRODUCTS_QUERY).getResultList();
		return products;
	}
	
	public static Product insert(Product product) {
		entityManager.getTransaction().begin();
		entityManager.persist(product);
		entityManager.getTransaction().commit();
		
		return product;
	}
	
	public static void delete(Long id) {
		entityManager.getTransaction().begin();
		entityManager.remove(getProductById(id));
		entityManager.getTransaction().commit();
	}
	
}
