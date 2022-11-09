package com.Assessment.Pizza.services;

import com.Assessment.Pizza.model.Customer;
import com.Assessment.Pizza.model.Pizza;
import com.Assessment.Pizza.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void verifyCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
    }

    public void createCustomer(Customer customer){
        customer = customerRepository.save(customer);
    }

    public ResponseEntity<?> getCustomer(Long customerId) {
        Optional<Customer> c = customerRepository.findById(customerId);
        return new ResponseEntity<> (c, HttpStatus.OK);
    }

    public void updateCustomer(Customer customer, Long customerId){
        customerRepository.save(customer);
    }

    public ResponseEntity<?> deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    public ResponseEntity<Iterable<Customer>> getAllCustomers() {
        Iterable<Customer> allCustomers = customerRepository.findAll();
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}
