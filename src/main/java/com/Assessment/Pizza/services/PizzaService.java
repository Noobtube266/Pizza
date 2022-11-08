package com.Assessment.Pizza.services;

import com.Assessment.Pizza.model.Pizza;
import com.Assessment.Pizza.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public void makePizza(Pizza pizza, String customerName){
        pizzaRepository.makePizza(pizza);
    }

    public Iterable<Pizza> getPizza(){
        return pizzaRepository.findAll();
    }

    public void editPizza(Pizza pizza, String customerName){
        pizzaRepository.editPizza(pizza);
    }

    public void trashPizza(Long number){
        pizzaRepository.trashPizza(number);
    }
}
