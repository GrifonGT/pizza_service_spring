package com.pizza.service.entity;

import jakarta.persistence.*;

import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "orders")
public class Order implements Comparable<Order> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User customer;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
    private Set<Pizza> pizzas = new TreeSet<>();

    @Column(name = "final_price")
    private Double price = 0.0;

    @Column(name = "is_active")
    private Boolean isActive;

    public Order() {
    }

    public Order(User customer, boolean isActive) {
        this.customer = customer;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Set<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(Set<Pizza> pizzas) {
        this.pizzas = pizzas;
        price = 0.0;
        pizzas.forEach(pizza -> price += pizza.getPrice());
    }

    public void addPizza(Pizza pizza) {
        price += pizza.getPrice();
        pizzas.add(pizza);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public int compareTo(Order order) {
        if (id == null) return 1;
        if (order.getId() == null) return -1;

        return id.compareTo(order.getId());
    }

}
