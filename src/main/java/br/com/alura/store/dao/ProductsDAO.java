package br.com.alura.store.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.store.model.Product;

public class ProductsDAO {
	private EntityManager entityManager;
	
	public ProductsDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void save(Product product) {
		this.entityManager.persist(product);
	}
	
	public Product findById(Long id) {
		return this.entityManager.find(Product.class, id);
	}
	
	public List<Product> findAll() {
		String jpql = "SELECT p FROM Product p";
		return this.entityManager.createQuery(jpql, Product.class).getResultList();
	}
	
	public List<Product> findByName(String name) {
		String jpql = "SELECT p FROM Product p WHERE p.name = :name";
		return this.entityManager.createQuery(jpql, Product.class)
				.setParameter("name", name)
				.getResultList();
	}
	
	public List <Product> findByCategoryName(String categoryName) {
		String jpql = "SELECT p FROM Product p WHERE p.category.name = :categoryName";
		return this.entityManager.createQuery(jpql, Product.class)
				.setParameter("categoryName", categoryName)
				.getResultList();
	}
}
