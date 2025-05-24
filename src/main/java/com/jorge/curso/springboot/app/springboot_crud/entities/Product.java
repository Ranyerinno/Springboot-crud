package com.jorge.curso.springboot.app.springboot_crud.entities;

import com.jorge.curso.springboot.app.springboot_crud.validation.IsExistsDb;
import com.jorge.curso.springboot.app.springboot_crud.validation.IsRequired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="products")
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @IsRequired
    @Size(min=3, max=20)
    private String name;
    @Min(value = 500, message = "{Min.product.price}")
    @NotNull(message = "{NotNull.product.price}")
    private Long price;
    @IsRequired
    private String description;
    @IsRequired
    @IsExistsDb
    private String sku;

}
