package br.com.alura.store.main;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.store.dao.CategoryDAO;
import br.com.alura.store.dao.ProductsDAO;
import br.com.alura.store.model.Category;
import br.com.alura.store.model.Product;
import br.com.alura.store.utils.JPAUtil;

public class InsertProduct {

	public static void main(String[] args) {
		Insert();
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProductsDAO productDAO = new ProductsDAO(entityManager);
		
		Product product = productDAO.findById(1l);
		System.out.println(product.getDescription());
		
		List<Product> allProducts = productDAO.findByCategoryName("celulares");
		
		allProducts.forEach(p -> System.out.println(p.getName()));
	}

	private static void Insert() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		Category celulares = new Category("computing");
		CategoryDAO categoryDAO = new CategoryDAO(entityManager);
		
		Product product = new Product("PC", "Acer", celulares);
		ProductsDAO productDAO = new ProductsDAO(entityManager);
		
		entityManager.getTransaction().begin();
		
		categoryDAO.save(celulares);
		productDAO.save(product);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
