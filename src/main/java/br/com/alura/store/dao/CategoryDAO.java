package br.com.alura.store.dao;

import javax.persistence.EntityManager;

import br.com.alura.store.model.Category;

public class CategoryDAO {
	private EntityManager entityManager;
	
	public CategoryDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void save(Category category) {
		this.entityManager.persist(category);
	}
}
