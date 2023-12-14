package com.pizza.service.dto;

import com.pizza.service.entity.Order;

import java.util.List;

public class OrderDTO {

    private Long id;
    private Long userId;

    private Double price;

    private List<PizzaDTO> pizzas;

    public OrderDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<PizzaDTO> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<PizzaDTO> pizzas) {
        this.pizzas = pizzas;
    }

    public static OrderDTO toDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setUserId(order.getCustomer().getId());
        dto.setPrice(order.getPrice());
        dto.setPizzas(order.getPizzas().stream().map(PizzaDTO::toDTO).toList());

        return dto;
    }
}
