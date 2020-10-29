package com.example.graphQLlibrary.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphQLlibrary.model.Author;
import com.example.graphQLlibrary.model.Tutorial;
import com.example.graphQLlibrary.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Pritesh
 */

@Component
public class TutorialResolver implements GraphQLResolver<Tutorial> {

    @Autowired
    private AuthorRepository authorRepository;

    public TutorialResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Tutorial tutorial) {
        return authorRepository.findById(tutorial.getAuthor_id()).orElseThrow(null);
    }
}
