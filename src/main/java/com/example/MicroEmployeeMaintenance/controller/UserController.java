package com.example.MicroEmployeeMaintenance.controller;

import com.example.MicroEmployeeMaintenance.model.User;
import com.example.MicroEmployeeMaintenance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value="/getUsers")
    public ResponseEntity<Object> get(){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<User> list  = userService.findAll();
            return new ResponseEntity<Object>(list,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("Could not find users", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="/getUser/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        try {
            User data  = userService.findById(id);
            return new ResponseEntity<Object>(data,HttpStatus.OK);
        }
        catch (Exception e) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("The user with this id does not exist", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="/getUserByUsername/{username}")
    public ResponseEntity<Object> getByUsername(@PathVariable String username){
        try {
            User data  = userService.findByUsername(username);
            return new ResponseEntity<Object>(data,HttpStatus.OK);
        }
        catch (Exception e) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("The user with this username does not exist", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value="/putUser")
    public ResponseEntity<Object> create(@RequestBody User user){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            user.setCreationDate(LocalDateTime.now());
            User res = userService.save(user);
            return new ResponseEntity<Object>(res,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("The user with this data does not exist", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<Object> update(@RequestBody User employee, @PathVariable Long id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {

            User currentEmployee = userService.findById(id);

            currentEmployee.setUsername(employee.getUsername());
            currentEmployee.setNif(employee.getNif());
            currentEmployee.setPersonalPhone(employee.getPersonalPhone());
            currentEmployee.setEmail(employee.getEmail());
            currentEmployee.setArea(employee.getArea());

            return new ResponseEntity<Object>(currentEmployee,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("The user could not be added with this data", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            User currentEmployee = userService.findById(id);
            userService.delete(currentEmployee);
            map.put("deleted", true);
            return new ResponseEntity<Object>(map,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("Unable to delete user with this id", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
