package com.example.MicroEmployeeMaintenance.model;

import lombok.*;

@Getter
@Data
@Builder
public class JwtRequest {


    private String username;
    private String password;

    public JwtRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public void setUsername(String email) {
        this.username = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}


