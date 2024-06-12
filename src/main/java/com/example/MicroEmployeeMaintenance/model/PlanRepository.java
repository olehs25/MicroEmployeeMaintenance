package com.example.MicroEmployeeMaintenance.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanRepository extends JpaRepository<Plan, Long> {


    Reservation save(Reservation reservation);




    Optional<Plan> findById(Long id);


}
