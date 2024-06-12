package com.example.MicroEmployeeMaintenance.model;

import com.example.MicroEmployeeMaintenance.model.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@EnableJpaAuditing
@Data
@Entity(name = "reservation")
public class Reservation implements  Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String userEmail;
    @GeneratedValue
    @LastModifiedDate
    private LocalDateTime creationDate;
    @Column
    private Date startDate;
    @Column
    private Date endDate;
    @Column
    private int isPaid;
    @Column
    private int isCreated;

}
