package com.example.MicroEmployeeMaintenance.service;

import com.example.MicroEmployeeMaintenance.model.Plan;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PlanService {

    public Plan save(Plan plan);

    public Optional<Plan> findById(Long id);

}
