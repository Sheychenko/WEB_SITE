package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;
//
//@Configuration
//@EnableWebSecurity
public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests(authorize -> authorize
//                .requestMatchers("/").permitAll()
//                .requestMatchers("/home").permitAll()
//                .requestMatchers("/register").permitAll()
//                .requestMatchers("/login").permitAll()
//                .requestMatchers("/css/**").permitAll()
//                .requestMatchers("/images/**").permitAll()
//                .anyRequest().authenticated()
//            )
//            .formLogin(formLogin -> formLogin
//                .loginPage("/login")
//                .permitAll()
//            )
//            .csrf(csrf -> csrf
//                .disable() //  CSRF   (   production)
//            )
//            .logout(logout -> logout
//                .logoutSuccessUrl("/login?logout")
//                .permitAll()
//            );
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
