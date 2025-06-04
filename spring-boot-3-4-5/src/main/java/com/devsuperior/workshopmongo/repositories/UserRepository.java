package com.devsuperior.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.devsuperior.workshopmongo.entities.User;

public interface UserRepository extends ReactiveMongoRepository<User, String>{

}
