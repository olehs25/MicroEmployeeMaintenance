package com.example.MicroEmployeeMaintenance.service;

import com.example.MicroEmployeeMaintenance.model.User;
import com.example.MicroEmployeeMaintenance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


public interface UserService {

    public List<User> findAll();

    public User save(User user);

    public User findById(Long id);

    public User findByUsername(String username);

    public void delete(User user);




}
