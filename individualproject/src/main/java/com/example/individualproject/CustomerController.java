package com.example.individualproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping("/list")
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> customers = service.getCustomerList();
        return ResponseEntity.ok(customers);
    }

    @PostMapping("/add")
    public ResponseEntity<?> newCustomer(@RequestBody Customer customer)
    {
        try {
            Customer newObject = service.newCustomer(customer);
            return new ResponseEntity<>(newObject,HttpStatus.CREATED);
        }
        catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable("id") Short id, @RequestBody Customer givenCustomer)
    {
        Customer customer = service.updateCustomer(id, givenCustomer);
        if (customer == null)
            return new ResponseEntity<>("Customer ID not found", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Short id) {
        if (service.deleteCustomer(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
        }
    }


}
