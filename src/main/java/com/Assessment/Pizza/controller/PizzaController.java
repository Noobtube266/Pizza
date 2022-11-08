package com.Assessment.Pizza.controller;

import com.Assessment.Pizza.model.Pizza;
import com.Assessment.Pizza.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping("/Pizza")
    public Iterable<Pizza> getPizza(){
        return pizzaService.getPizza();
    }
    @PostMapping("/pizza/{customerName}/pizza")
    public void makePizza(@PathVariable(value = "customerName") String customerName, @RequestBody Pizza pizza){
        pizzaService.makePizza(pizza, customerName);
    }

    @PutMapping("/pizza/{customerName}/pizza")
    public void editPizza(@PathVariable String customerName, @RequestBody Pizza pizza){
        pizzaService.editPizza(pizza, customerName);
    }
    @DeleteMapping("/pizza/{pizzaNumber}")
    public void trashPizza(@PathVariable Long number){
        pizzaService.trashPizza(number);
    }
}
