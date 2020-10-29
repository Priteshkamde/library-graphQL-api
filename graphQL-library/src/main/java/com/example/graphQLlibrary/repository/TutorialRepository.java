package com.example.graphQLlibrary.repository;

import com.example.graphQLlibrary.model.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Pritesh
 */
public interface TutorialRepository extends MongoRepository<Tutorial, String> {
}
