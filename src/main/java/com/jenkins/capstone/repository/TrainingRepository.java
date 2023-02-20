package com.jenkins.capstone.repository;

import com.jenkins.capstone.model.Training;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * This Repo will handle Crud operations with persistence layer
 * @Author - Alex jenkins
 * @Date - 02/20/23
 */
@Repository
public interface TrainingRepository extends CrudRepository <Training, String> {


}
