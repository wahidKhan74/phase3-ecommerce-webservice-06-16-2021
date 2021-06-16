package com.mcit.webservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mcit.webservice.entity.User;

@RestController
@RequestMapping("/userslogs")
public class UserController {
	
	List<User> users = new ArrayList<User>();
	
//	@RequestMapping(value="/list", method=RequestMethod.GET)
	@GetMapping("")
	public List<User> getUsers(){
		return users;
	}
	
//	@RequestMapping(value="/add", method=RequestMethod.POST)
	@PostMapping("")
	public List<User> addUsers(@RequestBody User user){
		users.add(user);
		return users;
	}
	
	@DeleteMapping("/{indexId}")
	public List<User> deleteUsers(@PathVariable int indexId){
		users.remove(indexId);
		return users;
	}
}
