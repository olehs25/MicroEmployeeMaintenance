package com.example.MicroEmployeeMaintenance.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@EnableJpaAuditing
@Data
@Entity(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String fullName;
    @Column(unique = true)
    private String nif;
    @Column
    private LocalDate birthDate;
    @Column
    private String personalPhone;
    @Column
    private String email;
    @Column
    private String country;
    @Column
    private String area;
    @GeneratedValue
    @LastModifiedDate
    private LocalDateTime creationDate;
    @Column
    private int active;
    @Column
    private  String login;
    @PrePersist
    @PreUpdate
    private void prepareDate() {

        this.email = email == null ? null : email.toLowerCase();
        this.nif = nif == null ? null : nif.toUpperCase();
    }

}