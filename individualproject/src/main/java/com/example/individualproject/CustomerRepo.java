package com.example.individualproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    @Query(value = "SELECT customer.customer_id, first_name, last_name, email, customer.active, create_date, COUNT(rental_date) as 'count' from rental, customer where (rental.customer_id = customer.customer_id) group by customer.customer_id order by first_name asc;", nativeQuery = true)
    List<Object[]> getCurrentCustomers();
}
