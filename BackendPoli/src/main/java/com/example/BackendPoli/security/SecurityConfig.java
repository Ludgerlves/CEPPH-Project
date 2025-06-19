package com.example.BackendPoli.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Para testes com Postman
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll() // login livre
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
                        .requestMatchers("/api/prof/**").hasRole("PROF")
                        .requestMatchers("/api/aluno/**").hasRole("ALUNO")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.disable()) // desabilita tela de login do Spring
                .httpBasic(Customizer.withDefaults()); // habilita autenticação via cabeçalho (Basic Auth)

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
