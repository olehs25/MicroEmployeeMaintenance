package com.example.MicroEmployeeMaintenance.controller;

import com.example.MicroEmployeeMaintenance.model.Plan;
import com.example.MicroEmployeeMaintenance.model.User;
import com.example.MicroEmployeeMaintenance.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/plan")
public class PlanController {

    @Autowired
    private PlanService planService;


    @GetMapping(value="/getPlan")
    public ResponseEntity<Object> getById(){
        try {
            Optional<Plan> data  = planService.findById(1L);
            return new ResponseEntity<Object>(data,HttpStatus.OK);
        }
        catch (Exception e) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("The plan with this id does not exist", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/updatePlan/{id}")
    public Plan update(@RequestBody Plan plan){
     return planService.save(plan);
    }

}
