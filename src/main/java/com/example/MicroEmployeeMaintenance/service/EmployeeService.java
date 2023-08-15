package com.example.MicroEmployeeMaintenance.service;

import java.util.List;

import com.example.MicroEmployeeMaintenance.model.Employee;

public interface EmployeeService{
    public List<Employee> findAll();

    public Employee save(Employee employee);

    public Employee findById(Long id);

    public void delete(Employee employee);

}
