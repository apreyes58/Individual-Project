package com.example.individualproject;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Film {
    @Id
    private String film_id;
    private String title;
    private String description, length, rating, rented, category;
    private List<String> actors;

    public Film(String film_id, String title, String description, String length, String rating, String rented, String category, List<String> actors) {
        super();
        this.film_id = film_id;
        this.title = title;
        this.description = description;
        this.length = length;
        this.rating = rating;
        this.rented = rented;
        this.category = category;
        this.actors = actors;
    }

    public Film(){}

    public String getFilm_id() {
        return film_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLength() {
        return length;
    }

    public String getRating() {
        return rating;
    }

    public String getRented() {
        return rented;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getActors() {
        return actors;
    }
}
