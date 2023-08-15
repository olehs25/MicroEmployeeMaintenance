package com.example.MicroEmployeeMaintenance.controller;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MicroEmployeeMaintenance.model.Employee;
import com.example.MicroEmployeeMaintenance.service.EmployeeService;


@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value="/getEmployees")
    public ResponseEntity<Object> get(){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Employee> list  = employeeService.findAll();
            return new ResponseEntity<Object>(list,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("Could not find employees", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="/getEmployee/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        try {
            Employee data  = employeeService.findById(id);
            return new ResponseEntity<Object>(data,HttpStatus.OK);
        }
        catch (Exception e) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("The employee with this id does not exist", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value="/putEmployee")
    public ResponseEntity<Object> create(@RequestBody Employee employee){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            employee.setCreationDate(LocalDateTime.now());
            Employee res = employeeService.save(employee);
            return new ResponseEntity<Object>(res,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("The employee with this data does not exist", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Object> update(@RequestBody Employee employee, @PathVariable Long id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {

            Employee currentEmployee = employeeService.findById(id);

            currentEmployee.setFullName(employee.getFullName());
            currentEmployee.setNif(employee.getNif());
            currentEmployee.setBirthDate(employee.getBirthDate());
            currentEmployee.setPersonalPhone(employee.getPersonalPhone());
            currentEmployee.setEmail(employee.getEmail());
            currentEmployee.setCountry(employee.getCountry());
            currentEmployee.setArea(employee.getArea());

            return new ResponseEntity<Object>(currentEmployee,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("The user could not be added with this data", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Employee currentEmployee = employeeService.findById(id);
            employeeService.delete(currentEmployee);
            map.put("deleted", true);
            return new ResponseEntity<Object>(map,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("Unable to delete user with this id", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
