package com.example.MicroEmployeeMaintenance.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {


    Reservation save(Reservation reservation);

    Optional<Reservation> findReservationByUserEmail(String userEmail);

    public List<Reservation> findAll();


    public Optional<Reservation> findById(Long id);

    public void delete(Reservation reservation);

}
