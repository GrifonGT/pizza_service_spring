package com.pizza.service.service.impl;

import com.pizza.service.dto.UserDTO;
import com.pizza.service.entity.User;
import com.pizza.service.repository.UserRepository;
import com.pizza.service.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long createUser(UserDTO userDTO) {
        User user = userRepository.save(UserDTO.fromDTO(userDTO));
        return user.getId();
    }

    @Override
    public UserDTO getById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.map(UserDTO::toDTO).orElse(null);
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream().map(UserDTO::toDTO).toList();
    }
}
