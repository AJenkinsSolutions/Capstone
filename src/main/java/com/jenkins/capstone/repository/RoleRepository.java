package com.jenkins.capstone.repository;

import com.jenkins.capstone.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Jpa Give us access to the sorting and pagination
 */
@Repository
public interface RoleRepository extends JpaRepository <Roles, Integer> {

    Roles getByRoleName(String roleName);
}
