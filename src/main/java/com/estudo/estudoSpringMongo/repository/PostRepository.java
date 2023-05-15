package com.estudo.estudoSpringMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.estudo.estudoSpringMongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	 
}
