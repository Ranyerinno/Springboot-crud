package com.jorge.curso.springboot.app.springboot_crud.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.jorge.curso.springboot.app.springboot_crud.entities.Rol;

public interface RolRepository extends CrudRepository<Rol, Long>{

    Optional<Rol> findByName(String name);

}
