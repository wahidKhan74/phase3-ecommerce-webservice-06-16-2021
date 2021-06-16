package com.mcit.webservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@RequestMapping(value="/" , method=RequestMethod.GET)
	@ResponseBody
	public String homePage() {
		return "Server is up and running !";
	}
	
	@RequestMapping(value="/users" , method=RequestMethod.GET)
	@ResponseBody
	public String usersPage() {
		return "Welcome users !";
	}
	
	@RequestMapping(value="/admin" , method=RequestMethod.GET)
	@ResponseBody
	public String adminPage() {
		return "Welcome admin !";
	}

}
