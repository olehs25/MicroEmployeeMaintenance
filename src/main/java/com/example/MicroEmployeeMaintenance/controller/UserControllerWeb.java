package com.example.MicroEmployeeMaintenance.controller;

import com.example.MicroEmployeeMaintenance.model.User;
import com.example.MicroEmployeeMaintenance.service.UserServiceWeb;
import com.example.MicroEmployeeMaintenance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import  com.example.MicroEmployeeMaintenance.service.UserDetailService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Optional;


@Controller
public class UserControllerWeb {

    @Autowired
    private UserServiceWeb userServiceWeb;

    @Autowired
   private UserDetailService userDetailService;

    @Autowired
    private  PasswordEncoder passEncoder;

    @RequestMapping("/user")
    public String index(Model model) {
        model.addAttribute("list", userServiceWeb.getAll());
        return "userindex";
    }

    @GetMapping("/user/save/{id}")
    public String showSave(@PathVariable("id") Long id, Model model) {
        if (id != null && id != 0) {
            model.addAttribute("user", userServiceWeb.get(id));
        } else {
            model.addAttribute("user", new User());
        }
        return "usersave";
    }

    @PostMapping("/user/save")
    public String save(User user, Model model) {
        user.setActive(1);
        String[] login = user.getEmail().split("@");
        String part1 = login[0];
        user.setLogin(part1);
        user.setCreationDate(LocalDateTime.now());
        String passwordEncode = passEncoder.encode(user.getPassword());
        user.setPassword(passwordEncode);
        userServiceWeb.save(user);
        return "redirect:/user";
    }


    @GetMapping("/user/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        userServiceWeb.delete(id);

        return "redirect:/user";
    }

}