package com.example.MicroEmployeeMaintenance.Dao;

import com.example.MicroEmployeeMaintenance.model.Plan;
import com.example.MicroEmployeeMaintenance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanDao extends JpaRepository<Plan, Long> {

}