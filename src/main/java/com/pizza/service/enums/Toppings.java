package com.pizza.service.enums;

public enum Toppings {
    TOPPING1("topping1", 20.0),
    TOPPING2("topping2", 30.0),
    TOPPING3("topping3", 40.0);

    private final String name;
    private final Double price;

    Toppings(String name, Double price) {
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
        return "Topping: " + name + " price: " + price;
    }

    public static Toppings getByName(String name) {
        for (Toppings topping : Toppings.values()) {
            if (topping.getName().equals(name)) {
                return topping;
            }
        }

        throw new IllegalArgumentException(String.format("Topping %s not found", name));
    }
}
