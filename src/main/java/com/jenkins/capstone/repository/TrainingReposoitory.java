package com.jenkins.capstone.repository;

import com.jenkins.capstone.model.Training;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingReposoitory extends CrudRepository <Training, String> {
}
