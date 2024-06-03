package com.example.MicroEmployeeMaintenance.controller;

import com.example.MicroEmployeeMaintenance.model.Employee;
import com.example.MicroEmployeeMaintenance.service.EmployeeServiceWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;


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
        employee.setActive(1);
        String[] login = employee.getEmail().split("@");
        String part1 = login[0];
        employee.setUsername(part1);
        employeeServiceWeb.save(employee);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        employeeServiceWeb.delete(id);

        return "redirect:/";
    }

}