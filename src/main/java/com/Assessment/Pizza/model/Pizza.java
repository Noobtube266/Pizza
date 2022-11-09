package com.Assessment.Pizza.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "number")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long number;
    private String crust;
    private String[] toppings;
    private String status;
    @ManyToOne
    @JoinColumn(name = "customer_name")
    private Customer customer;

    public Pizza(){
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public String[] getToppings() {
        return toppings;
    }

    public void setToppings(String[] toppings) {
        this.toppings = toppings;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "number=" + number +
                ", crust='" + crust + '\'' +
                ", toppings=" + Arrays.toString(toppings) +
                ", status='" + status + '\'' +
                ", customer=" + customer +
                '}';
    }
}
