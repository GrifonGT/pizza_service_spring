package com.pizza.service.entity;

import com.pizza.service.enums.Pizzas;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "pizza")
public class Pizza implements Comparable<Pizza> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pizza_id")
    private Long id;

    @Column(name = "pizza_type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private Double price = 0.0;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pizza_topping", joinColumns = @JoinColumn(name = "pizza_id"), inverseJoinColumns = @JoinColumn(name = "topping_id"))
    private Set<Topping> toppings = new TreeSet<>();

    private String additionally;

    public Pizza() {
    }

    public Pizza(Pizzas pizzas) {
        this(pizzas, null);
    }

    public Pizza(Pizzas pizzas, Order order) {
        type = pizzas.getName();
        price = pizzas.getPrice();
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(Set<Topping> toppings) {
        this.toppings = toppings;
    }

    public void addToppings(Collection<Topping> toppings) {
        this.toppings.addAll(toppings);

        for (Topping topping : toppings) {
            price += topping.getPrice();
        }
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAdditionally() {
        return additionally;
    }

    public void setAdditionally(String additionally) {
        this.additionally = additionally;
    }

    @Override
    public int compareTo(Pizza pizza) {
        if (id == null) return 1;
        if (pizza.getId() == null) return -1;

        return id.compareTo(pizza.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return Objects.equals(id, pizza.getId())
                && Objects.equals(type, pizza.getType())
                && Objects.equals(order, pizza.getOrder())
                && Objects.equals(price, pizza.getPrice())
                && Objects.equals(additionally, pizza.getAdditionally());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, order, price, additionally);
    }
}
