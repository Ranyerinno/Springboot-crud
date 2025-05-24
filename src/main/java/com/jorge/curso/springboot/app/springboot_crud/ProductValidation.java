package com.jorge.curso.springboot.app.springboot_crud;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jorge.curso.springboot.app.springboot_crud.entities.Product;

@Component
public class ProductValidation implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.product.name", "Es requerido");
        
        if (product.getDescription() == null || product.getDescription().isBlank()) {
            errors.rejectValue("description", "NotBlank.product.description", "Es requerido, por favor");
        }

        if (product.getPrice() == null) {
            errors.rejectValue("price", "NotNull.product.price", "El precio es obligatorio");
        }else if (product.getPrice() < 500) {
            errors.rejectValue("price", "Min.product.price", "Debe ser un valor numerico mayor o igual que 500");
        }

    }

}
