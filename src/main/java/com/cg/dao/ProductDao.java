package com.cg.dao;

import java.util.List;

import com.cg.entity.Product;
import com.cg.exception.ProductNotFoundException;

public interface ProductDao {
	Product create (Product product);
	
	Product retrieveById(int id) throws ProductNotFoundException;
	
	List<Product> retrieveByCategory(String category) throws ProductNotFoundException;
	
	List<Product> retrieveByPriceRange(double min, double max) throws ProductNotFoundException;
	
	List<Product> retrieveAll() throws ProductNotFoundException;
	
	Product update(Product product);
	
	Boolean delete(int id) throws ProductNotFoundException;
}
