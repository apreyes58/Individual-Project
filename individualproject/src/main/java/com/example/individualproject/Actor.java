package com.example.individualproject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Actor {
    @Id
    private String actor_id;
    private String first_name, last_name;
    private String movies;
    private List<String> top_movies;

    public Actor(String actor_id, String first_name, String last_name, String movies, List<String> top_movies) {
        super();
        this.actor_id = actor_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.movies = movies;
        this.top_movies = top_movies;
    }

    public Actor(){}

    public String getActor_id() {
        return actor_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getMovies() {
        return movies;
    }

    public List<String> getTop_movies() {
        return top_movies;
    }
}
