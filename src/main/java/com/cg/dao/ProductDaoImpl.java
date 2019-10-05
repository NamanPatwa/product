package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.entity.Product;
import com.cg.exception.ProductNotFoundException;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private EntityManager mgr;
	
	@Override
	public Product create(Product product) {
		mgr.persist(product);
		return product;
	}

	@Override
	public Product retrieveById(int id) throws ProductNotFoundException {
		Product product = mgr.find(Product.class, id);
		if(product == null)
			throw new ProductNotFoundException("Product with id "+id+"not found");
		return product;
	}

	@Override
	public List<Product> retrieveByCategory(String category) throws ProductNotFoundException {
		List<Product> products = mgr.createNamedQuery("byCategory").setParameter("cat", category).getResultList();
		if(products.size() == 0)
			throw new ProductNotFoundException("There are no product of category "+category);
		return products;
	}

	@Override
	public List<Product> retrieveByPriceRange(double min, double max) throws ProductNotFoundException {
		List<Product> products = mgr.createNamedQuery("byPriceRange").setParameter("min", min).setParameter("max", max).getResultList();
		if(products.size() == 0)
			throw new ProductNotFoundException("There are no product in price range "+min+" and "+max);
		return products;
	}

	@Override
	public List<Product> retrieveAll() throws ProductNotFoundException {
		List<Product> products = mgr.createNamedQuery("findAll").getResultList();
		if(products.size() == 0) 
			throw new ProductNotFoundException("Product table is empty");
		return products;
	}

	@Override
	public Product update(Product product) {
		mgr.merge(product);
		return product;
	}

	@Override
	public Boolean delete(int id) throws ProductNotFoundException {
		Product product = mgr.find(Product.class, id);
		if(product == null)
			throw new ProductNotFoundException("Product with id "+id+" does not exist");
		mgr.remove(product);
		return true;
	}

}
