package com.example.MicroEmployeeMaintenance.model;

import com.example.MicroEmployeeMaintenance.model.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@EnableJpaAuditing
@Data
@Entity(name = "employee")
public class Employee implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String nif;
    @Column
    private String personalPhone;
    @Column
    private String email;
    @Column
    private String area;
    @GeneratedValue
    @LastModifiedDate
    private LocalDateTime creationDate;
    @Column
    private int active;
    @Column
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @PrePersist
    @PreUpdate
    private void prepareDate() {

        this.email = email == null ? null : email.toLowerCase();
        this.nif = nif == null ? null : nif.toUpperCase();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}