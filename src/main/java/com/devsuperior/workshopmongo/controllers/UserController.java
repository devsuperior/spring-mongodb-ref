package com.devsuperior.workshopmongo.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.workshopmongo.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User user1 = new User("1", "Maria", "maria@gmail.com");
		User user2 = new User("2", "Jorge", "jorge@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(user1, user2));
		
		return ResponseEntity.ok().body(list);
	}
}
