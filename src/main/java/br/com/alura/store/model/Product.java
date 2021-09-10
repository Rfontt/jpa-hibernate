package br.com.alura.store.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private LocalDate dateRegistration = LocalDate.now();
	@ManyToOne
	private Category category;
	
	public Product() {
	}
	
	public Product(String name, String description, Category category) {
		this.name = name;
		this.description = description;
		this.category = category;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

	public LocalDate getDateRegistration() {
		return dateRegistration;
	}

	public void setDateRegistration(LocalDate dateRegistration) {
		this.dateRegistration = dateRegistration;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
