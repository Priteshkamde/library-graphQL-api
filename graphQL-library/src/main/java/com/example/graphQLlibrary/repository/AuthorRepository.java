package com.example.graphQLlibrary.repository;

import com.example.graphQLlibrary.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Pritesh
 */
public interface AuthorRepository extends MongoRepository<Author, String> {
}
