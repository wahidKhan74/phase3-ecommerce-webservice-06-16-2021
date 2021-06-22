package com.mcit.webservice.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class HomeControllerTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	TestRestTemplate testTemplate;
	
	@Test
	@DisplayName("Test : test users")
	void testForUsers() {
		String url = "http://localhost:"+port+"/users";
		ResponseEntity<String> response = testTemplate.getForEntity(url, String.class);		
		Assertions.assertEquals("Welcome users !", response.getBody());
	}
	
	@Test
	@DisplayName("Test : test admin")
	void testForAdmin() {
		String url = "http://localhost:"+port+"/admin";
		ResponseEntity<String> response = testTemplate.getForEntity(url, String.class);		
		Assertions.assertEquals("Welcome admin !", response.getBody());
	}
}
