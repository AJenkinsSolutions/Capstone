package com.jenkins.capstone.repository;

import com.jenkins.capstone.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository <Skills, Integer> {

}
