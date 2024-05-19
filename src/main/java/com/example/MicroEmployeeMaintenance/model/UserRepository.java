package com.example.MicroEmployeeMaintenance.model;

import org.springframework.data.jpa.repository.JpaRepository;
import  com.example.MicroEmployeeMaintenance.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);


    UserDetails findByUsername(String username);

    User save(User user);
}
