package com.mcit.webservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcit.webservice.entity.Product;
import com.mcit.webservice.exception.InvalidDataException;
import com.mcit.webservice.exception.ResouceNotFoundException;
import com.mcit.webservice.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	// Get all list of products
	@GetMapping("/products")
	public List<Product> getProducts() {
		List<Product> products = productRepository.findAll();
		if (products.isEmpty()) {
			throw new ResouceNotFoundException("Products are not available !");
		}
		return products;
	}

	// get products by id
	@GetMapping("/products/{id}")
	public Product getOneProduct(@PathVariable long id) {

		return this.productRepository.findById(id).orElseThrow(() -> {
			throw new ResouceNotFoundException("Product is not available with id " + id);
		});
	}

	// create products
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		if (product == null) {
			throw new InvalidDataException("Product creation failed ! missing project object !");
		}
		return this.productRepository.save(product);
	}

	// update product by id
	@PutMapping("/products/{id}")
	public Product updateProduct(@PathVariable long id, @RequestBody Product product) {
		// find a product
		this.productRepository.findById(id).orElseThrow(() -> {
			throw new ResouceNotFoundException("Product is not available with id " + id);
		});

		return this.productRepository.save(product);
	}

	// delete product by id
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable long id) {

		// find a product
		Product fetchedProduct = this.productRepository.findById(id).orElseThrow(() -> {
			throw new ResouceNotFoundException("Product is not available with id " + id);
		});

		this.productRepository.delete(fetchedProduct);
	}

}
