package com.pizza.service.controller;

import com.pizza.service.dto.AddPizzaDTO;
import com.pizza.service.dto.IdDTO;
import com.pizza.service.service.PizzaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pizza")
public class PizzaController {

    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping("/add")  //body {"userId": 1, "type": "pizza1", (optional)"toppings":[{"name": "topping1},{"name": "topping2}]}
    public ResponseEntity addPizza(@Valid @RequestBody AddPizzaDTO pizza) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new IdDTO(pizzaService.addPizza(pizza.getUserId(), pizza)));
    }

    @GetMapping("/all")
    public ResponseEntity getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(pizzaService.getAll());
    }
}
