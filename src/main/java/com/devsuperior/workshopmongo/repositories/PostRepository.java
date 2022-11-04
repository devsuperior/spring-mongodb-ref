package com.devsuperior.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devsuperior.workshopmongo.entities.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
