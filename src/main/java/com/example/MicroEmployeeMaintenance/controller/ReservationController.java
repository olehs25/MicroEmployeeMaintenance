package com.example.MicroEmployeeMaintenance.controller;

import com.example.MicroEmployeeMaintenance.model.Reservation;
import com.example.MicroEmployeeMaintenance.model.User;
import com.example.MicroEmployeeMaintenance.service.ReservationService;
import com.example.MicroEmployeeMaintenance.service.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReservationServiceImpl reservationServiceImpl;

    @GetMapping(value="getReservations")
    public ResponseEntity<Object> get(){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Reservation> list  = reservationService.findAll();
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("Could not find reservations", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="getReservation/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        try {
            Reservation data  = reservationService.findById(id);
            return new ResponseEntity<Object>(data,HttpStatus.OK);
        }
        catch (Exception e) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("The reservation with this id does not exist", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="getReservationByUserEmail/{userEmail}")
    public ResponseEntity<Object> getReservationByUserEmail(@PathVariable String useEmail){
        try {
            Reservation data  = reservationService.findReservationByUseEmail(useEmail);
            return new ResponseEntity<Object>(data,HttpStatus.OK);
        }
        catch (Exception e) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("The reservation with this username does not exist", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("deleteReservation/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Reservation currentReservation = reservationService.findById(id);
            reservationService.delete(currentReservation);
            map.put("deleted", true);
            return new ResponseEntity<Object>(map,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("Unable to delete reservation with this id", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value="putReservation")
    public ResponseEntity<Object> create(@RequestBody Reservation reservation){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            reservation.setCreationDate(LocalDateTime.now());
            reservation.setIsCreated(1);
            Reservation res = reservationService.save(reservation);
            System.out.println("ID DE LA RESERVAA: "+res.getId());
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("The reservation with this data not exist", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateReservation/{id}")
    public ResponseEntity<Object> updateReservation(@PathVariable Long id, @RequestBody Reservation reservationDetails) {
        Map<String, Object> map = new HashMap<>();
        try {
            Reservation updatedReservation = reservationServiceImpl.updateReservation(id, reservationDetails);
            return new ResponseEntity<>(updatedReservation, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", "Unable to update reservation");
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
