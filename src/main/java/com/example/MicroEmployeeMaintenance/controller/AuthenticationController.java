package com.example.MicroEmployeeMaintenance.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import com.example.MicroEmployeeMaintenance.config.JwtUtil;
import com.example.MicroEmployeeMaintenance.model.JwtRequest;
import com.example.MicroEmployeeMaintenance.model.JwtResponse;
import com.example.MicroEmployeeMaintenance.model.User;
import com.example.MicroEmployeeMaintenance.model.enums.UserRole;
import com.example.MicroEmployeeMaintenance.model.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired private AuthenticationManager authenticationManager;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passEncoder;

    @PostMapping(value = "generate-token")
    public ResponseEntity<JwtResponse> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        } catch (UsernameNotFoundException usernameNotFoundException) {
            throw new Exception("Usuario no encontrado" + usernameNotFoundException.getMessage());
        }
        UserDetails usuarioDetails = userRepository.findByUsername(jwtRequest.getUsername()).orElseThrow();
        System.out.println("USUARIOO:" +usuarioDetails);
        String token = jwtUtil.generateToken(usuarioDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) {
        try {
            System.out.println("USERNAME Y PASS: "+username+" "+password);
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException disabledException) {
            throw new DisabledException("Usuario deshabilitado" + disabledException.getMessage());
        } catch (BadCredentialsException badCredentialsException) {
            throw new BadCredentialsException("Credenciales incorrectas" + badCredentialsException.getMessage());
        }
    }


    @GetMapping(value = "register")
    public User register(@RequestBody String username){
        return userRepository.findByUsername(username).orElseThrow();
    }



    @PostMapping(value = "login")
    public JwtResponse login(@RequestBody JwtRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtUtil.generateToken(user);
        return JwtResponse.builder()
                .token(token)
                .build();
    }

    @PostMapping(value = "register")
    public JwtResponse register2(@RequestBody User request)
    {
        User user = new User();
        user.setFullName(request.getFullName());
        String passwordEncode = passEncoder.encode(request.getPassword());
        user.setActive(1);
        user.setIsSuscribed(0);
        user.setPassword(passwordEncode);
        user.setCreationDate(LocalDateTime.now());
        user.setCountry(request.getCountry());
        user.setEmail(request.getEmail());
        String[] login = user.getEmail().split("@");
        String part1 = login[0];
        String part2 = login[1];
        user.setUsername(part1);
        user.setNif(request.getNif());
        user.setLanguage(request.getLanguage());
        user.setPersonalPhone(request.getPersonalPhone());
        if ((part2.contains("admin"))) {
            System.out.println("es adminnnnnnnnnnnnnnn:" +part2);
            user.setRole(UserRole.ADMIN);
        }else{
            System.out.println("es userrrrrrrrrrrrrrr: "+part2);
            user.setRole(UserRole.USER);
        }
        this.userRepository.save(user);
        return  JwtResponse.builder().token(jwtUtil.generateToken(user)).build();
    }

    @GetMapping(value="actual-usuario/{username}")
    public Optional<User> getUsuarioActual(@PathVariable String username) {
        System.out.println("USERNAMEEE: "+username);
        Optional<User> user = userRepository.findByUsername(username);
        return user;
    }


}

