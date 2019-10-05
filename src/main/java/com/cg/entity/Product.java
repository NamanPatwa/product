package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "proseq", sequenceName = "pro_seq", allocationSize = 1)
@NamedQuery(name = "byCategory" ,query = "SELECT p FROM Product p WHERE p.category=:cat")
@NamedQuery(name = "byPriceRange",query = "SELECT p FROM Product p WHERE p.price BETWEEN :min and :max")
@NamedQuery(name = "byRating",query = "SELECT p FROM Product p WHERE p.rating=:rat")
@NamedQuery(name = "sortBy",query = "SELECT p FROM Product p ORDER BY p.price")
@NamedQuery(name = "findAll",query = "SELECT p FROM Product p")
public class Product {
	@Id
	@GeneratedValue(generator = "proseq")
	private int productId;
	@Column(length = 20)
	private String productName;
	private double rating;
	private int stock;
	private double price;
	@Column(length = 20)
	private String category;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
