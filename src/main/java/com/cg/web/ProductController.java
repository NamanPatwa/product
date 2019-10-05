package com.cg.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Product;
import com.cg.exception.ProductNotFoundException;
import com.cg.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

		@Autowired
		ProductService service;
		
		@PostMapping(value = "/add",produces = "application/json",consumes = "application/json")
		public Product addProduct(@RequestBody Product product) {
			return service.addProduct(product);
		}
		
		@GetMapping(value = "/id/{id}",produces = "application/json")
		public Product fetchById(@PathVariable int id) throws ProductNotFoundException {
			return service.fetchById(id);
		}
		
		@GetMapping(value = "/category/{category}",produces = "application/json")
		public List<Product> fetchByCategory(@PathVariable String category) throws ProductNotFoundException {
			return service.fetchByCategory(category);
		}
		
		@GetMapping(value = "/price/{min}/{max}",produces = "application/json")
		public List<Product> fetchByPriceRange(@PathVariable double min,@PathVariable double max) throws ProductNotFoundException {
			return service.fetchByPriceRange(min, max);
		}

		@GetMapping(value = "/all",produces = "application/json")
		public List<Product> fetchAll() throws ProductNotFoundException {
			return service.fetchAll();
		}
		
		@PutMapping(value = "/update",consumes = "application/json",produces = "application/json")
		public Product updateProduct(@RequestBody Product product) {
			return service.updateProduct(product);
		}

		@DeleteMapping(value = "/delete/{id}")
		public Boolean deleteProduct(@PathVariable int id) throws ProductNotFoundException {
			return service.deleteProduct(id);
		}
}
