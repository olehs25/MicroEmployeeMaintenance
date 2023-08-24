package com.example.MicroEmployeeMaintenance.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

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

    @PrePersist
    @PreUpdate
    private void prepareDate() {

        this.email = email == null ? null : email.toLowerCase();
        this.nif = nif == null ? null : nif.toUpperCase();
    }

}