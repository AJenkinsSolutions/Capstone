package com.jenkins.capstone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@ComponentScan("com.jenkins.capstone.security")
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
                    auth.requestMatchers("/dashboard").authenticated();
                    auth.requestMatchers("/showUserProfileView").authenticated();
                    auth.requestMatchers("/assets/**").permitAll();
                    auth.requestMatchers("").permitAll();
                    auth.requestMatchers("/").permitAll();
                    auth.requestMatchers("/home").permitAll();
                    auth.requestMatchers("/about").permitAll();
                    auth.requestMatchers("/projects").permitAll();
                    auth.requestMatchers("/training/**").permitAll();
                    auth.requestMatchers("/contact").permitAll();
                    auth.requestMatchers("/public/**").permitAll();
                    auth.requestMatchers("/saveMsg").permitAll();
                    auth.requestMatchers("/showUserProfileView").permitAll();
                })
                .formLogin(form -> {
                    form.loginPage("/login").permitAll();
                    form.loginProcessingUrl("/login").permitAll();
                    form.defaultSuccessUrl("/test", true);
                    form.failureUrl("/login?error=true");
                })
                .logout(logout ->{
                    logout.invalidateHttpSession(true).permitAll();
                })
                .httpBasic(Customizer.withDefaults())
                .build();

    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();

    }

    //v2
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("adminpass")
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }




}
