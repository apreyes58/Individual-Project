package com.example.individualproject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Actor {
    @Id
    private String actor_id;
    private String first_name, last_name;

    public Actor(String actor_id, String first_name, String last_name) {
        super();
        this.actor_id = actor_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getActor_id() {
        return actor_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }
}
