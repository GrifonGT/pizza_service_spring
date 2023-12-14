package com.pizza.service.service;

import com.pizza.service.dto.PizzaDTO;

import java.util.List;
import java.util.Map;

public interface PizzaService {

    Long addPizza(Long userId, PizzaDTO pizzaDTO);

    Map<String, Object> getAll();
}
