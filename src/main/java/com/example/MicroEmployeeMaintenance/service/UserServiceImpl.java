package com.example.MicroEmployeeMaintenance.service;

import com.example.MicroEmployeeMaintenance.Dao.UserDao;
import com.example.MicroEmployeeMaintenance.model.User;
import com.example.MicroEmployeeMaintenance.model.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.MicroEmployeeMaintenance.config.JwtUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;


    @Override
    @Transactional
    public List<User> findAll() {
        return (List<User>) userDao.findAll();
    }

    @Override
    @Transactional
    public User save(User person) {
        return userDao.save(person);
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    @Transactional
    public void delete(User person) {
        userDao.delete(person);

    }
    public boolean checkUserByEmail(String email){
        User user = userRepository.findUserByEmail(email);
        return user != null;
    }

    public ResponseEntity<Object> subscribeUser(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
            user.setIsSuscribed(1);
            userRepository.save(user);

            // Generar un nuevo token JWT
            UserDetails userDetails = userRepository.findByUsername(user.getUsername()).orElseThrow();
            String token = jwtUtil.generateToken(userDetails);

            response.put("user", user);
            response.put("token", token);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

