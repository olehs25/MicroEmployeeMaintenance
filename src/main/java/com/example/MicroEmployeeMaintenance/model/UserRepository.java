package com.example.MicroEmployeeMaintenance.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User save(User user);

    Optional<User> findByUsername(String username);

    //Optional<User> findUserByUsernameAndPassword(String username, String password);

    public List<User> findAll();


    public Optional<User> findById(Long id);

    public void delete(User user);

}
