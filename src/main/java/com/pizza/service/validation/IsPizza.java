package com.pizza.service.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PizzaValidator.class)
@Documented
public @interface IsPizza {
    String message() default "Is not pizza";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
