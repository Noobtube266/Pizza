package com.Assessment.Pizza.controller;

import com.Assessment.Pizza.model.Customer;
import com.Assessment.Pizza.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    public void createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
    }


    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?> getCustomer(@PathVariable Long customerId) {
        customerService.verifyCustomer(customerId);
        return customerService.getCustomer(customerId);
    }

    @GetMapping("/customer")
    public ResponseEntity<Iterable<Customer>> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PutMapping("/customer/{customerId}")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable Long customerId) {
        customerService.verifyCustomer(customerId);
        customerService.updateCustomer(customer, customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId) {
        customerService.verifyCustomer(customerId);
        return customerService.deleteCustomer(customerId);
    }
}
