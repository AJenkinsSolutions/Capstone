package com.jenkins.capstone.repository;

import com.jenkins.capstone.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository <Developer, Integer> {

    /**
     * Custom query for authentication process
     * @param email
     * @return
     * Author - Alex jenkins
     */
    Developer findByEmail(String email);
}
