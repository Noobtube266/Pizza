package com.Assessment.Pizza.repository;

import com.Assessment.Pizza.model.Pizza;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PizzaRepository extends CrudRepository<Pizza, Long> {

    Iterable<Pizza> getByCustomerId(Long customerId);

    @Query(value = "Select * From book WHERE name LIKE CONCAT('%', :query, '%')", nativeQuery = true)
    Iterable<Pizza> searchPizza(String query);
}
