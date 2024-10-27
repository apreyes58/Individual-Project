package com.example.individualproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customers;

    public List<Customer> getCustomerList() {
        List<Object[]> objects = customers.getCurrentCustomers();
        List<Customer> customerList = new ArrayList<>();

        for (Object[] customer : objects) {
            Short id = (Short) (customer[0]);
            String first_name = String.valueOf(customer[1]);
            String last_name = String.valueOf(customer[2]);
            String email = String.valueOf(customer[3]);
            Boolean active = (Boolean) (customer[4]);
            String create_date = String.valueOf(customer[5]);
            Long rental_count = (Long) (customer[6]);


            customerList.add(new Customer(id, first_name, last_name, email, active, create_date, rental_count, (short) 1, (short) 1));
        }
        return customerList;
    }

    public Customer newCustomer(Customer customer) {
        if (customers.existsById(Integer.valueOf(customer.getCustomer_id())))
            throw new IllegalArgumentException("Customer ID already taken.");

        if (customer.getStore_id() == null)
            customer.setStore_id((short) 1);
        if (customer.getAddress_id() == null)
            customer.setAddress_id((short) 1);
        return customers.save(customer);
    }

    public Customer updateCustomer(Short id, Customer givenCustomer) {
        Optional<Customer> existingCustomer = customers.findById(Integer.valueOf(id));
        if (existingCustomer.isPresent()) {
            Customer customer = existingCustomer.get();
            customer.setFirst_name(givenCustomer.getFirst_name());
            customer.setLast_name(givenCustomer.getLast_name());
            customer.setEmail(givenCustomer.getEmail());
            customer.setActive(givenCustomer.getActive());
            return customers.save(customer);
        }
        return null;
    }

    public boolean deleteCustomer(Short id) {
        if (customers.existsById(Integer.valueOf(id))) {
            customers.deleteById(Integer.valueOf(id));
            return true;
        }
        return false;
    }

}
