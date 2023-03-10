package com.jenkins.capstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.jenkins.capstone")
@EntityScan("com.jenkins.capstone.model")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class CapstoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneApplication.class, args);
	}

}
