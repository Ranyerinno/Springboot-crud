package com.jorge.curso.springboot.app.springboot_crud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jorge.curso.springboot.app.springboot_crud.entities.Rol;
import com.jorge.curso.springboot.app.springboot_crud.entities.User;
import com.jorge.curso.springboot.app.springboot_crud.repositories.RolRepository;
import com.jorge.curso.springboot.app.springboot_crud.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

   @Autowired
   private RolRepository rolRepository;

   @Autowired
   private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
       return (List<User>) userRepository.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {

      Optional<Rol> optionalRol = rolRepository.findByName("ROL_USER");
      List<Rol> roles = new ArrayList<>();

      optionalRol.ifPresent(roles::add);

      if (user.getAdmin()) {
         Optional<Rol> optionalRolAdmin = rolRepository.findByName("ROL_ADMIN");

         optionalRolAdmin.ifPresent(roles::add);

      }

      user.setRoles(roles);
      user.setPassword(passwordEncoder.encode(user.getPassword()));

       return userRepository.save(user);
    }

}
