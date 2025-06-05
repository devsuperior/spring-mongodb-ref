package com.devsuperior.workshopmongo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.workshopmongo.dto.UserDTO;
import com.devsuperior.workshopmongo.services.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping
	public Flux<UserDTO> findAll() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Mono<ResponseEntity<UserDTO>> findById(@PathVariable String id) {
		return service.findById(id).map(userDto -> ResponseEntity.ok().body(userDto));
	}
}
