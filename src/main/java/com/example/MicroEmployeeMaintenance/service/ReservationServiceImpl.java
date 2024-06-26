package com.example.MicroEmployeeMaintenance.service;

import com.example.MicroEmployeeMaintenance.Dao.ReservationDao;
import com.example.MicroEmployeeMaintenance.Dao.UserDao;
import com.example.MicroEmployeeMaintenance.model.Reservation;
import com.example.MicroEmployeeMaintenance.model.User;
import com.example.MicroEmployeeMaintenance.service.ReservationService;
import com.example.MicroEmployeeMaintenance.model.ReservationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{


    @Autowired
    private ReservationDao reservationDao;

    @Override
    @Transactional
    public List<Reservation> findAll() {
        return  reservationDao.findAll();
    }

    @Override
    @Transactional
    public Reservation save(Reservation reservation) {
        return reservationDao.save(reservation);
    }

    @Override
    public Reservation findById(Long id) {
        return reservationDao.findById(id).orElse(null);
    }

    @Override
    public Reservation findReservationByUseEmail(String userEmail) {
        return reservationDao.findReservationByUserEmail(userEmail);
    }

    @Override
    @Transactional
    public void delete(Reservation reservation) {
        reservationDao.delete(reservation);

    }

    public Reservation updateReservation(Long id, Reservation reservationUpdated) {
        Reservation reservation = reservationDao.findReservationById(id);

        reservation.setUserEmail(reservation.getUserEmail());
        reservation.setStartDate(reservation.getStartDate());
        reservation.setEndDate(reservation.getEndDate());
        reservation.setIsPaid(reservationUpdated.getIsPaid());
        reservation.setIsCreated(reservation.getIsCreated());
        reservation.setCreationDate(reservation.getCreationDate());

        return reservationDao.save(reservation);
    }
}

