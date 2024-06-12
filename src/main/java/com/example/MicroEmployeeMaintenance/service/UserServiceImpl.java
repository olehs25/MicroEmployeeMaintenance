package com.example.MicroEmployeeMaintenance.service;

import com.example.MicroEmployeeMaintenance.Dao.UserDao;
import com.example.MicroEmployeeMaintenance.model.User;
import com.example.MicroEmployeeMaintenance.model.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRepository userRepository;

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
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    public User subscribeUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setIsSuscribed(1);
        return userRepository.save(user);
    }
}

