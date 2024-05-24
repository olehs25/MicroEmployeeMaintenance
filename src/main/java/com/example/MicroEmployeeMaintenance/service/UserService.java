package com.example.MicroEmployeeMaintenance.service;

import com.example.MicroEmployeeMaintenance.model.User;
import java.util.List;
import java.util.Optional;


public interface UserService {

    public List<User> findAll();

    public User save(User user);

    public User findById(Long id);

    public User findByUsername(String username);

    public void delete(User user);




}
