package com.pizza.service.validation;

import com.pizza.service.enums.Pizzas;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PizzaValidator implements ConstraintValidator<IsPizza, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            Pizzas.getByName(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
