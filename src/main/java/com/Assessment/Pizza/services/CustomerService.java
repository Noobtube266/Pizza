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

    public void createCustomer(Customer customer){
        customer = customerRepository.save(customer);
    }

    public Iterable<Customer> getCustomer(){
        return customerRepository.findAll();
    }
}
