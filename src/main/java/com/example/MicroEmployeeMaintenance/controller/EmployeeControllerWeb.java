package com.example.MicroEmployeeMaintenance.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.MicroEmployeeMaintenance.generator.ExcelGenerator;
import com.example.MicroEmployeeMaintenance.service.EmployeeServiceWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.MicroEmployeeMaintenance.generator.ExcelGenerator;
import com.example.MicroEmployeeMaintenance.model.Employee;
import com.example.MicroEmployeeMaintenance.service.EmployeeService;

import javax.servlet.http.HttpServletResponse;


@Controller
public class EmployeeControllerWeb {

    @Autowired
    private EmployeeServiceWeb employeeServiceWeb;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("list", employeeServiceWeb.getAll());
        return "index";
    }

    @GetMapping("/save/{id}")
    public String showSave(@PathVariable("id") Long id, Model model) {
        if (id != null && id != 0) {
            model.addAttribute("employee", employeeServiceWeb.get(id));
        } else {
            model.addAttribute("employee", new Employee());
        }
        return "save";
    }

    @PostMapping("/save")
    public String save(Employee employee, Model model) {
        employee.setCreationDate(LocalDateTime.now());
        employeeServiceWeb.save(employee);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        employeeServiceWeb.delete(id);

        return "redirect:/";
    }

}