package com.pizza.service.controller;

import com.pizza.service.dto.IdDTO;
import com.pizza.service.dto.UserDTO;
import com.pizza.service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable Long id) {
        UserDTO user = service.getById(id);

        return user == null
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                : ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping("/create")  //body {"firstName": "name", "lastName": "surname"}
    public ResponseEntity create(@Valid @RequestBody UserDTO user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new IdDTO(service.createUser(user)));
    }

}
