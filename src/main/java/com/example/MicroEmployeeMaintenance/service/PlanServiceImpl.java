package com.example.MicroEmployeeMaintenance.service;

import com.example.MicroEmployeeMaintenance.Dao.PlanDao;
import com.example.MicroEmployeeMaintenance.model.Plan;
import com.example.MicroEmployeeMaintenance.model.PlanRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlanServiceImpl implements PlanService{


    @Autowired
    private PlanDao planDao;

    @Autowired
    private PlanRepository planRepository;

    @Override
    @Transactional
    public Plan save(Plan plan) {
        return planDao.save(plan);
    }


    public Optional<Plan> findById(Long id) {
        return planRepository.findById(id);
    }


}

