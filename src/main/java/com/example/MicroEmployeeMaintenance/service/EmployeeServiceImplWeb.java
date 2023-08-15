package com.example.MicroEmployeeMaintenance.service;

import com.example.MicroEmployeeMaintenance.Dao.EmployeeDao;
import com.example.MicroEmployeeMaintenance.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImplWeb extends GenericServiceImpl<Employee, Long> implements EmployeeServiceWeb {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public CrudRepository<Employee, Long> getDao() {
        return employeeDao;
    }

}
