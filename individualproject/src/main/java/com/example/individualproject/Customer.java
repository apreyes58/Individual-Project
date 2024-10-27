package com.example.individualproject;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    private Short customer_id;
    private String first_name;
    private String last_name;
    private String email;
    private Boolean active;
    private String create_date;
    private Long rental_count;
    private Short store_id;
    private Short address_id;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rental> rentals = new ArrayList<>();

    public Customer(Short customer_id, String first_name, String last_name, String email, Boolean active, String create_date, Long rental_count, Short store_id, Short address_id)
    {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.active = active;
        this.create_date = create_date;
        this.rental_count = rental_count;
        this.store_id = store_id;
        this.address_id = address_id;
    }

    public Customer(){}

    public Short getCustomer_id() {
        return customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getCreate_date() {
        return create_date;
    }

    public Long getRental_count() {
        return rental_count;
    }

    public Short getStore_id() {
        return store_id;
    }

    public void setStore_id(Short store_id) {
        this.store_id = store_id;
    }

    public Short getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Short address_id) {
        this.address_id = address_id;
    }
}
