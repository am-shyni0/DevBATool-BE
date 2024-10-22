package com.devBA.devBATool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF protection. Use with caution.
                .csrf(csrf -> csrf.disable())
                // Configure URL authorization
                .authorizeHttpRequests(authz -> authz
//                        .requestMatchers("/registration").permitAll()
//                        .requestMatchers("/login").permitAll()
                                .anyRequest().permitAll() // Require authentication for all other requests
                )

                // Configure HTTP Basic authentication
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
