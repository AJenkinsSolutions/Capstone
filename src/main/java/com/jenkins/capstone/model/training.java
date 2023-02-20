package com.jenkins.capstone.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 *
 */
@Data
@Entity
@Table(name = "trainings")
public class training extends CoreEntity {
    @Id
    private String day;

    @Column(name = "training_name")
    private String trainingName;

    @Enumerated(EnumType.STRING)
    private Type type;

    //special java clss which allows you to define a set of constants
    public enum Type{
        FUNDAMENTALS, ESSENTIALS, ADVANCED, DEVELOPMENT, PROJECT
    }

}
