package com.mcit.webservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.mcit.webservice.controller.ProductController;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class Phase3EcommerceWebservice06162021ApplicationTests {

	@Autowired
	private ProductController productCtrl;
	
	@LocalServerPort
	private int port;
	
	@Autowired
	TestRestTemplate testTemplate;
	
	
	@Test
	@DisplayName("Test : Load Application context")
	void contextLoads() {
		Assertions.assertNotNull(productCtrl);
	}
	
	@Test
	@DisplayName("Test : server runing test")
	void testForServerRun() {
		String url = "http://localhost:"+port+"/";
		ResponseEntity<String> response = testTemplate.getForEntity(url, String.class);
		
		Assertions.assertEquals("Server is up and running !", response.getBody());
	}
	
	

}
