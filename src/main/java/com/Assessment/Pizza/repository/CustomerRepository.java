package com.Assessment.Pizza.repository;

import com.Assessment.Pizza.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String> {
}
