package com.jenkins.capstone.model;

import com.jenkins.capstone.audit.AuditEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 *This base Entity will be audited to we can see
 * when it was created, updated etc ...
 * @Author- Alex Jenkins
 */

@Getter
@Setter
@Entity
@Table(name = "trainings")
public class Training extends AuditEntity {

    //Seems to be equals hashcode bug in lombok
    @Id
    private String day;

    @Column(name = "training_name")
    private String trainingName;

    @Enumerated(EnumType.STRING)
    private Type type;

    public Training() {
    }

    public Training(Type type) {
        this.type = type;
    }

    //special java clss which allows you to define a set of constants
    public enum Type{
        FUNDAMENTALS, ESSENTIALS, ADVANCED, DEVELOPMENT, PROJECT
    }

}
