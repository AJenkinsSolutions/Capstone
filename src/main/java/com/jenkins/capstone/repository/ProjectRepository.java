package com.jenkins.capstone.repository;

import com.jenkins.capstone.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository <Project, Integer> {

}
