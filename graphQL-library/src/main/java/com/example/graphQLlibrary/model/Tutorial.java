package com.example.graphQLlibrary.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Pritesh
 */
@Document(collection = "tutorials")
public class Tutorial {
    @Id
    private String id;
    private String title;
    private String description;
    private String author_id;

    public Tutorial() {
    }

    public Tutorial(String title, String description, String author_id) {
        this.title = title;
        this.description = description;
        this.author_id = author_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }
}
