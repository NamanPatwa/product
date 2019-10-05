package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.ProductDao;
import com.cg.entity.Product;
import com.cg.exception.ProductNotFoundException;

@Service
@Transactional(rollbackFor = ProductNotFoundException.class)
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	
	@Override
	public Product addProduct(Product product) {
		return dao.create(product);
	}

	@Override
	public Product fetchById(int id) throws ProductNotFoundException {
		return dao.retrieveById(id);
	}

	@Override
	public List<Product> fetchByCategory(String category) throws ProductNotFoundException {
		return dao.retrieveByCategory(category);
	}

	@Override
	public List<Product> fetchByPriceRange(double min, double max) throws ProductNotFoundException {
		return dao.retrieveByPriceRange(min, max);
	}

	@Override
	public List<Product> fetchAll() throws ProductNotFoundException {
		return dao.retrieveAll();
	}

	@Override
	public Product updateProduct(Product product) {
		return dao.update(product);
	}

	@Override
	public Boolean deleteProduct(int id) throws ProductNotFoundException {
		return dao.delete(id);
	}

}
