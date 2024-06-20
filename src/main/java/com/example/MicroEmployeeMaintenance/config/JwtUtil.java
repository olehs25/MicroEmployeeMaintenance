package com.example.MicroEmployeeMaintenance.config;

import com.example.MicroEmployeeMaintenance.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

// Da métodos para validar/crear token, extraer datos de este
@Component
public class JwtUtil {

    private String SECRET_KEY = "plataformatenis";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        if (userDetails instanceof User) {
            User user = (User) userDetails;
            claims.put("fullName", user.getFullName());
            claims.put("email", user.getEmail());
            claims.put("isSuscribed", user.getIsSuscribed());
            claims.put("id", user.getId());
            claims.put("role", user.getRole());
            claims.put("username", user.getUsername());
            claims.put("nif", user.getNif());
            claims.put("personalPhone", user.getPersonalPhone());
            claims.put("country", user.getCountry());
            //claims.put("creationDate", user.getCreationDate());
            claims.put("active", user.getActive());
            claims.put("language", user.getLanguage());
            claims.put("password", user.getPassword());
            claims.put("photo", user.getPhoto());
        }
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
