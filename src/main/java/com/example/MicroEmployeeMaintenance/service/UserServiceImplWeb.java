package com.example.MicroEmployeeMaintenance.service;

import com.example.MicroEmployeeMaintenance.Dao.UserDao;
import com.example.MicroEmployeeMaintenance.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplWeb extends GenericServiceImpl<User, Long> implements UserServiceWeb {

    @Autowired
    private UserDao userDao;

    @Override
    public CrudRepository<User, Long> getDao() {
        return userDao;
    }

}
