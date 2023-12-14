package com.pizza.service.controller;

import com.pizza.service.dto.AddPizzaDTO;
import com.pizza.service.dto.IdDTO;
import com.pizza.service.dto.UserDTO;
import com.pizza.service.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //confirm order
    @PostMapping("/confirm") //body {"id": 1}
    public ResponseEntity confirmOrder(@Valid @RequestBody IdDTO idDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.confirmOrder(idDTO.getId()));
    }

    //get order
    @GetMapping("/{id}")
    public ResponseEntity getOrder(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrder(id));
    }

    //get user orders
    @GetMapping("/user/{id}")
    public ResponseEntity getUserOrders(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getUserOrders(id));
    }
}
