package com.pizza.service.dto;

import com.pizza.service.entity.Pizza;
import com.pizza.service.enums.Pizzas;
import com.pizza.service.validation.IsPizza;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PizzaDTO {
    protected Long id;
    @NotBlank
    @IsPizza
    protected String type;
    protected Double price;

    protected List<ToppingDTO> toppings;

    protected String additionally;

    public PizzaDTO() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<ToppingDTO> getToppings() {
        return toppings;
    }

    public void setToppings(List<ToppingDTO> toppings) {
        this.toppings = toppings;
    }

    public String getAdditionally() {
        return additionally;
    }

    public void setAdditionally(String additionally) {
        this.additionally = additionally;
    }

    @Override
    public String toString() {
        return "PizzaDTO{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", additionally='" + additionally + '\'' +
                '}';
    }

    public static PizzaDTO toDTO(Pizza pizza) {
        PizzaDTO dto = new PizzaDTO();
        dto.setId(pizza.getId());
        dto.setType(pizza.getType());
        dto.setPrice(pizza.getPrice());
        dto.setAdditionally(pizza.getAdditionally());

        return dto;
    }

    public static Pizza fromDTO(PizzaDTO dto) {
        Pizza pizza = new Pizza(Pizzas.getByName(dto.getType()));

        if (dto.getToppings() != null) {
            Set<String> toppings = dto.getToppings().stream().map(ToppingDTO::getName).collect(Collectors.toSet());
            pizza.addToppings(toppings.stream().map(ToppingDTO::create).toList());
            pizza.setAdditionally(String.format("[%s]", String.join(", ", toppings)));
        }

        return pizza;
    }
}
