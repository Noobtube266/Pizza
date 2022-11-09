package com.Assessment.Pizza.services;

import com.Assessment.Pizza.model.Pizza;
import com.Assessment.Pizza.repository.CustomerRepository;
import com.Assessment.Pizza.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public void makePizza(Pizza pizza, Long customerId){
        customerRepository.findById(customerId).map(customer -> {
            pizza.setCustomer(customer);
            return pizzaRepository.save(pizza);
        });
    }

    public Iterable<Pizza> getPizza(){
        return pizzaRepository.findAll();
    }

    public ResponseEntity<?> getPizzaByNumber(Long pizzaNumber) {
        Pizza pizza = pizzaRepository.findById(pizzaNumber).orElse(null);
        return new ResponseEntity<>(pizza, HttpStatus.OK);
    }

    public void editPizza(Pizza pizza, Long customerId) {
        customerRepository.findById(customerId).map(customer ->{
            pizza.setCustomer(customer);
            return pizzaRepository.save(pizza);
    });
    }

    public void trashPizza(Long pizzaNumber){
        pizzaRepository.deleteById(pizzaNumber);
    }

    public Iterable<Pizza> getByCustomerId(Long customerId){
        return pizzaRepository.getByCustomerId(customerId);
    }

    public Iterable<Pizza> findPizzaByName(String query) {
        return pizzaRepository.searchPizza(query);
    }
}
