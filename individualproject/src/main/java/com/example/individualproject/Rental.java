package com.example.individualproject;

import jakarta.persistence.*;

@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short rental_id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    public Short getRental_id() {
        return rental_id;
    }
}
