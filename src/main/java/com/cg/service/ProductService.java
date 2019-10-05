package com.cg.service;

import java.util.List;

import com.cg.entity.Product;
import com.cg.exception.ProductNotFoundException;

public interface ProductService {
	Product addProduct (Product product);
	
	Product fetchById(int id) throws ProductNotFoundException;
	
	List<Product> fetchByCategory(String category) throws ProductNotFoundException;
	
	List<Product> fetchByPriceRange(double min, double max) throws ProductNotFoundException;
	
	List<Product> fetchAll() throws ProductNotFoundException;
	
	Product updateProduct(Product product);
	
	Boolean deleteProduct(int id) throws ProductNotFoundException;
}
