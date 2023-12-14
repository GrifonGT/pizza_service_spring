package com.pizza.service.enums;

public enum Pizzas {
    PIZZA1("pizza1", 150.0),
    PIZZA2("pizza2", 200.0);

    private final String name;
    private final Double price;

    Pizzas(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pizza : " + name + " price: " + price;
    }

    public static Pizzas getByName(String name) {
        for (Pizzas pizza : Pizzas.values()) {
            if (pizza.getName().equals(name)) {
                return pizza;
            }
        }

        throw new IllegalArgumentException(String.format("Pizza %s not found", name));
    }
}
