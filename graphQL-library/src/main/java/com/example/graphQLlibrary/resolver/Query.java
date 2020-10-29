package com.example.graphQLlibrary.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphQLlibrary.model.Author;
import com.example.graphQLlibrary.model.Tutorial;
import com.example.graphQLlibrary.repository.AuthorRepository;
import com.example.graphQLlibrary.repository.TutorialRepository;
import org.springframework.stereotype.Component;

/**
 * @author Pritesh
 */
@Component
public class Query implements GraphQLQueryResolver {
    AuthorRepository authorRepository;
    TutorialRepository tutorialRepository;

    public Query(AuthorRepository authorRepository, TutorialRepository tutorialRepository) {
        this.authorRepository = authorRepository;
        this.tutorialRepository = tutorialRepository;
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Iterable<Tutorial> findAllTutorials() {
        return tutorialRepository.findAll();
    }

    public int countAuthors() {
        return (int) authorRepository.count();
    }

    public int countTutorials() {
        return (int) tutorialRepository.count();
    }
}
