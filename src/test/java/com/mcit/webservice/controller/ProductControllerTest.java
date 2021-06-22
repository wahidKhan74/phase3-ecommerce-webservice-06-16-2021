package com.mcit.webservice.controller;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import com.mcit.webservice.entity.Product;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	TestRestTemplate testTemplate;
	
	@Test
	@DisplayName("Test : test list products")
	void testListProducts() {
		String url = "http://localhost:"+port+"/api/products";
		ResponseEntity<List> response = testTemplate.getForEntity(url, List.class);		
		Assertions.assertEquals(false, response.getBody().isEmpty());
		Assertions.assertEquals(200, response.getStatusCodeValue());
	}
	
	@Test
	@DisplayName("Test : test one products")
	void testOneProduct() {
		String url = "http://localhost:"+port+"/api/products/1";
		ResponseEntity<Product> response = testTemplate.getForEntity(url, Product.class);		
		Assertions.assertNotNull(response.getBody());
		Assertions.assertEquals(200, response.getStatusCodeValue());
	}
	
	
	@Test
	@DisplayName("Test : add one products")
	void testAddProduct() {
		String url = "http://localhost:"+port+"/api/products/";
		// create a porudct
		Product product = new Product("Lenovo Laptop abc", "It is a laptop", 9877);
		HttpEntity<Product> requestObj = new HttpEntity<Product>(product);
		
		
		ResponseEntity<Product> response = testTemplate.postForEntity(url, requestObj, Product.class);		
		Assertions.assertNotNull(response.getBody());
		Assertions.assertEquals("Lenovo Laptop abc", response.getBody().getName());
		Assertions.assertEquals(200, response.getStatusCodeValue());
	}
	
	// update & delete
}
