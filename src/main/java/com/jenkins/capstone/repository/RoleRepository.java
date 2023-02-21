package com.jenkins.capstone.repository;

import com.jenkins.capstone.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Roles, Integer> {
}
