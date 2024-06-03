package com.example.MicroEmployeeMaintenance.service;

import com.example.MicroEmployeeMaintenance.model.Reservation;
import com.example.MicroEmployeeMaintenance.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {

    public List<Reservation> findAll();

    public Reservation save(Reservation reservation);

    public Reservation findById(Long id);

    public Reservation findReservationByUseEmail(String userEmail);

    public void delete(Reservation reservation);

}
