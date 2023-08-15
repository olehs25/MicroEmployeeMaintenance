package com.example.MicroEmployeeMaintenance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MicroEmployeeMaintenance.model.Employee;
import com.example.MicroEmployeeMaintenance.Dao.EmployeeDao;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public List<Employee> findAll() {
        return (List<Employee>) employeeDao.findAll();
    }

    @Override
    @Transactional
    public Employee save(Employee person) {
        return employeeDao.save(person);
    }

    @Override
    public Employee findById(Long id) {
        return employeeDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Employee person) {
        employeeDao.delete(person);

    }

}

