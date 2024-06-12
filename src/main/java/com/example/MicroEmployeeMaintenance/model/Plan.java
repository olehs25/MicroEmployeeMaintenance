package com.example.MicroEmployeeMaintenance.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import java.io.Serializable;

@EnableJpaAuditing
@Data
@Entity(name = "plan")
public class Plan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String content;


}