package com.example.individualproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    @Query(value = "SELECT customer.customer_id, customer.first_name, customer.last_name, customer.email, customer.active, customer.create_date, COUNT(rental.rental_date) as rental_count FROM customer LEFT JOIN rental ON rental.customer_id = customer.customer_id GROUP BY customer.customer_id ORDER BY customer.first_name ASC;", nativeQuery = true)
    List<Object[]> getCurrentCustomers();
}
