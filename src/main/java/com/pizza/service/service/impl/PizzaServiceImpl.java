package com.pizza.service.service.impl;

import com.pizza.service.dto.PizzaDTO;
import com.pizza.service.entity.Order;
import com.pizza.service.entity.Pizza;
import com.pizza.service.entity.User;
import com.pizza.service.enums.Pizzas;
import com.pizza.service.enums.Toppings;
import com.pizza.service.repository.OrderRepository;
import com.pizza.service.repository.PizzaRepository;
import com.pizza.service.repository.UserRepository;
import com.pizza.service.service.PizzaService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public PizzaServiceImpl(PizzaRepository pizzaRepository, OrderRepository orderRepository, UserRepository userRepository) {
        this.pizzaRepository = pizzaRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Long addPizza(Long userId, PizzaDTO pizzaDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User not found"));

        Order order = user.getOrders().stream().filter(Order::getActive).findFirst().orElse(null);

        if (order == null) {
            order = new Order(user, true);
            order = orderRepository.save(order);

            user.getOrders().add(order);
            userRepository.save(user);
        }

        Pizza pizza = PizzaDTO.fromDTO(pizzaDTO);
        order.addPizza(pizza);
        pizza.setOrder(order);
        orderRepository.save(order);

        return order.getId();
    }

    @Override
    public Map<String, Object> getAll() {
        Map<String, Object> container = new HashMap<>();
        container.put("pizzas", Pizzas.values());
        container.put("toppings", Toppings.values());
        return container;
    }

}
