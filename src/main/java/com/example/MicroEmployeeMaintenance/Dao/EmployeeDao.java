package com.example.MicroEmployeeMaintenance.Dao;

import com.example.MicroEmployeeMaintenance.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Long> {

}