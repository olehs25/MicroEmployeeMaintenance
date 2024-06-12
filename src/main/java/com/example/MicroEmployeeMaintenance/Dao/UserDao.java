package com.example.MicroEmployeeMaintenance.Dao;

import com.example.MicroEmployeeMaintenance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    User findByUsername(String username);
}