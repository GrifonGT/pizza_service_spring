package com.pizza.service.service;

import com.pizza.service.dto.OrderDTO;
import com.pizza.service.entity.Order;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface OrderService {

    Map<String, Object> confirmOrder(Long id);

    OrderDTO getOrder(Long id);

    List<OrderDTO> getUserOrders(Long id);
}
