package com.jenkins.capstone.service;

import com.jenkins.capstone.model.Training;
import com.jenkins.capstone.repository.TrainingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TrainingService {

    //could add interface

    private TrainingRepository trainingRepository;

    @Autowired
    public TrainingService(TrainingRepository trainingRepository) {
        System.out.println("TrainingRepository bean created");
        this.trainingRepository = trainingRepository;
    }


    /**
     * Fecthes all the trainings from ther database
     * @return - A list of all training conferences from the persistent layer
     */

    public List<Training> getAllTrainingTypes(){
        //Iterable Type cast
        return  (List<Training>) trainingRepository.findAll();

    }


}
