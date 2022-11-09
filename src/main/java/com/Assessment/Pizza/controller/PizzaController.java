package com.Assessment.Pizza.controller;

import com.Assessment.Pizza.model.Pizza;
import com.Assessment.Pizza.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping("/Pizza")
    public Iterable<Pizza> getPizza(){
        return pizzaService.getPizza();
    }
    @PostMapping("/pizza/{customerId}/pizza")
    public void makePizza(@PathVariable(value = "customerId") Long customerId, @RequestBody Pizza pizza){
        pizzaService.makePizza(pizza, customerId);
    }

    @GetMapping("/pizza/{pizzaNumber}")
    public ResponseEntity<?> getPizzaByNumber(@PathVariable Long pizzaNumber) {
        return pizzaService.getPizzaByNumber(pizzaNumber);
    }

    @PutMapping("/pizza/{customerId}/pizza")
    public void editPizza(@PathVariable Long customerId, @RequestBody Pizza pizza){
        pizzaService.editPizza(pizza, customerId);
    }
    @DeleteMapping("/pizza/{pizzaNumber}")
    public void trashPizza(@PathVariable Long number){
        pizzaService.trashPizza(number);
    }

    @GetMapping("/pizza/{customerId}/pizza")
    public Iterable<Pizza> getByCustomerId(@PathVariable Long customerId) {
        return pizzaService.getByCustomerId(customerId);
    }

    @GetMapping("/searchPizza")
    public Iterable<Pizza> searchPizza(@RequestParam("query") String query) {
        return pizzaService.findPizzaByName(query);
    }
}
