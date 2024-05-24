package com.example.MicroEmployeeMaintenance.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class DemoController {


    @PostMapping(value = "api")
    public String demo()
    {
        return "Demo from secure endpoint";
    }


}
