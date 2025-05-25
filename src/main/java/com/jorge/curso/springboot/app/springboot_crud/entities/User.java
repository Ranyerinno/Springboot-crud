package com.jorge.curso.springboot.app.springboot_crud.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jorge.curso.springboot.app.springboot_crud.validation.IsRequired;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @IsRequired
    @Column(unique = true)
    @Size(min = 5, max = 50)
    private String userName;

    @IsRequired
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(min = 8)
    private String password;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean enable;

    @ManyToMany
    private List<Rol> roles;

    @Transient
    private Boolean admin;

}
