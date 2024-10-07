package com.example.individualproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customers;

    public List<Customer> getCustomerList()
    {
        List<Object[]> objects = customers.getCurrentCustomers();
        List<Customer> customerList = new ArrayList<>();

        for (Object[] customer: objects)
        {
            Short id = (Short) (customer[0]);
            String first_name = String.valueOf(customer[1]);
            String last_name = String.valueOf(customer[2]);
            String email = String.valueOf(customer[3]);
            Boolean active = (Boolean) (customer[4]);
            String create_date = String.valueOf(customer[5]);
            Long rental_count = (Long) (customer[6]);


            customerList.add(new Customer(id, first_name, last_name, email, active, create_date, rental_count));
        }
        return customerList;
    }
}
