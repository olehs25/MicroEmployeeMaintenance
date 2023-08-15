package com.example.MicroEmployeeMaintenance.Dao;

import com.example.MicroEmployeeMaintenance.model.Employee;
import org.springframework.data.repository.CrudRepository;

import com.example.MicroEmployeeMaintenance.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDaoWeb extends CrudRepository<Employee, Long> {

}