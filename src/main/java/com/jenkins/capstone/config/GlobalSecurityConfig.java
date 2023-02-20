package com.jenkins.capstone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class GlobalSecurityConfig {



    /**
     * From Spring Security 5.7, the WebSecurityConfigurerAdapter is deprecated to encourage users
     * to move towards a component-based security configuration. It is recommended to create a bean
     * of type SecurityFilterChain for security related configurations.
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/assets/**").permitAll();
                    auth.requestMatchers("").permitAll();
                    auth.requestMatchers("/").permitAll();
                    auth.requestMatchers("/home").permitAll();
                    auth.requestMatchers("/about").permitAll();
                    auth.requestMatchers("/projects").permitAll();
                    auth.requestMatchers("/training/**").permitAll();
                    auth.requestMatchers("/contact").permitAll();

                })
                .build();

    }



}
