package com.Assessment.Pizza.repository;

import com.Assessment.Pizza.model.Pizza;
import org.springframework.data.repository.CrudRepository;

public interface PizzaRepository extends CrudRepository<Pizza, String> {
    void trashPizza(Long pizza);

    void editPizza(Pizza pizza);

    void makePizza(Pizza pizza);
}
