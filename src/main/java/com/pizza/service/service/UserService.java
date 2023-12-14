package com.pizza.service.service;

import com.pizza.service.dto.UserDTO;

import java.util.List;

public interface UserService {

    Long createUser(UserDTO user);

    UserDTO getById(Long id);

    List<UserDTO> getAll();
}
