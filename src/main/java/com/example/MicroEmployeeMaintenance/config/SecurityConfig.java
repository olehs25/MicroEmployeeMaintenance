package com.example.MicroEmployeeMaintenance.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {



    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    private final AuthenticationProvider authProvider;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
         http
                .csrf((csrf) -> csrf.disable())
                 .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Habilitar CORS para 4200
                // public routes
                .authorizeHttpRequests()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/auth/**")).permitAll()
                 .requestMatchers(AntPathRequestMatcher.antMatcher("/user/**")).permitAll()
                 .requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.OPTIONS)).permitAll()
                .anyRequest().authenticated()
                .and()
                 .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
                 //.addFilterBefore(new CustomOriginFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();


    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200")); // Permitir el origen (angular) de tu frontend
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
