package com.example.MicroEmployeeMaintenance.controller;

import java.security.Principal;

import com.example.MicroEmployeeMaintenance.config.JwtUtil;
import com.example.MicroEmployeeMaintenance.model.JwtRequest;
import com.example.MicroEmployeeMaintenance.model.JwtResponse;
import com.example.MicroEmployeeMaintenance.model.User;
import com.example.MicroEmployeeMaintenance.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import  com.example.MicroEmployeeMaintenance.model.UserRepository;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired private AuthenticationManager authenticationManager;

    private UserService userService;

    @Autowired private JwtUtil jwtUtil;

    @Autowired private UserRepository userRepository;

    @PostMapping(value = "generate-token")
    public ResponseEntity<JwtResponse> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        } catch (UsernameNotFoundException usernameNotFoundException) {
            throw new Exception("Usuario no encontrado" + usernameNotFoundException.getMessage());
        }
        UserDetails usuarioDetails = userRepository.findByUsername(jwtRequest.getUsername());
        String token = jwtUtil.generateToken(usuarioDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException disabledException) {
            throw new DisabledException("Usuario deshabilitado" + disabledException.getMessage());
        } catch (BadCredentialsException badCredentialsException) {
            throw new BadCredentialsException("Credenciales incorrectas" + badCredentialsException.getMessage());
        }
    }


    @GetMapping(value = "register")
    public String register(Long id)
    {
        String message = "";
      User user1 = (User) this.userService.findById(id);
        if(user1.getUsername() ==null){
             message =  "No hay user";
        }else{
             message =  "SI hay user";

        }
        return message;
    }

    @GetMapping("/actual-usuario")
    public User getUsuarioActual(Principal principal) {
        return (User) this.userService.findByUsername(principal.getName());
    }
}

