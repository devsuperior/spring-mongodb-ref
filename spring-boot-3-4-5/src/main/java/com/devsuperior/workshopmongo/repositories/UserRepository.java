package com.devsuperior.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devsuperior.workshopmongo.entities.User;

public interface UserRepository extends MongoRepository<User, String>{

}
