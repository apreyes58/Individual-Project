package com.example.individualproject;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

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

    public Customer(Short customer_id, String first_name, String last_name, String email, Boolean active, String create_date, Long rental_count)
    {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.active = active;
        this.create_date = create_date;
        this.rental_count = rental_count;
    }

    public Short getCustomer_id() {
        return customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getActive() {
        return active;
    }

    public String getCreate_date() {
        return create_date;
    }

    public Long getRental_count() {
        return rental_count;
    }
}
