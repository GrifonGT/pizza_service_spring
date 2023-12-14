package com.pizza.service.dto;

import com.pizza.service.entity.Topping;
import com.pizza.service.enums.Toppings;

public class ToppingDTO {

    private Long id;
    private String name;

    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public static ToppingDTO toDTO(Topping topping) {
        ToppingDTO dto = new ToppingDTO();
        dto.setName(topping.getName());
        return dto;
    }

    public static Topping fromDTO(ToppingDTO dto) {
        return create(dto.getName());
    }

    public static Topping create(String name) {
        Topping topping = new Topping();
        Toppings toppings = Toppings.getByName(name);
        topping.setName(toppings.getName());
        topping.setPrice(toppings.getPrice());

        return topping;
    }
}
