package com.example.Projecto.para.registar.muculmanos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(requests -> requests
                .anyRequest().permitAll() // Permitir acesso irrestrito a todos os endpoints
            )
            .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable())); // Necessário para o H2 Console
        return http.build();
    }
}
