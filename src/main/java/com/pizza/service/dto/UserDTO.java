package com.pizza.service.dto;

import com.pizza.service.entity.User;
import jakarta.validation.constraints.NotBlank;

public class UserDTO {
    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    private UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());

        return dto;
    }

    public static User fromDTO(UserDTO dto) {
        return new User(dto.getFirstName(), dto.getLastName());
    }
}
