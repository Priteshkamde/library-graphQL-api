package com.example.graphQLlibrary.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphQLlibrary.model.Author;
import com.example.graphQLlibrary.model.Tutorial;
import com.example.graphQLlibrary.repository.AuthorRepository;
import com.example.graphQLlibrary.repository.TutorialRepository;

import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Pritesh
 */
@Component
public class Mutation implements GraphQLMutationResolver {
    AuthorRepository authorRepository;
    TutorialRepository tutorialRepository;

    public Mutation(AuthorRepository authorRepository, TutorialRepository tutorialRepository) {
        this.authorRepository = authorRepository;
        this.tutorialRepository = tutorialRepository;
    }

    public Author createAuthor(String name, Integer age) {
        Author author = new Author();
        author.setName(name);
        author.setAge(age);

        authorRepository.save(author);

        return author;
    }

    public Tutorial createTutorial(String title, String description, String authorId) {
        Tutorial book = new Tutorial();
        book.setAuthor_id(authorId);
        book.setTitle(title);
        book.setDescription(description);

        tutorialRepository.save(book);

        return book;
    }

    public boolean deleteTutorial(String id) {
        tutorialRepository.deleteById(id);
        return true;
    }

    public Tutorial updateTutorial(String id, String title, String description) throws Exception {
        Optional<Tutorial> optTutorial = tutorialRepository.findById(id);

        if (optTutorial.isPresent()) {
            Tutorial tutorial = optTutorial.get();

            if (title != null)
                tutorial.setTitle(title);
            if (description != null)
                tutorial.setDescription(description);

            tutorialRepository.save(tutorial);
            return tutorial;
        }

        throw new Exception("Not found Tutorial to update!");
    }
}
