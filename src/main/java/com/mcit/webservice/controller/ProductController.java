package com.mcit.webservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcit.webservice.entity.Product;

@RestController
@RequestMapping("/api")
public class ProductController {

	List<Product> products = new ArrayList<Product>();

	// Get all list of products
	@GetMapping("/products")
	public List<Product> getProducts() {
		return products;
	}

	// get products by id
	@GetMapping("/products/{id}")
	public Product getOneProduct(@PathVariable long id) {
		Product product =null;
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i).getId()==id) {
				product = products.get(i);
			}
		}
		return product;
	}
	
	// create products
	@PostMapping("/products")
	public List<Product> addProduct(@RequestBody Product product) {
		products.add(product);
		return products;
	}

	// update product by id
	@PutMapping("/products/{id}")
	public List<Product> updateProduct(@PathVariable long id, @RequestBody Product product) {
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i).getId()==id) {
				products.set(i, product);
				return products;
			}
		}
		return products;
	}
	
	// delete product by id
	@DeleteMapping("/products/{id}")
	public List<Product> deleteProduct(@PathVariable long id) {
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i).getId()==id) {
				products.remove(i);
			}
		}
		return products;
	}
	
	

}
