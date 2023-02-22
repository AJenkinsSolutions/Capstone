package com.jenkins.capstone.model;

import com.jenkins.capstone.audit.AuditEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "project")
public class Project extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int projectId;

    @NotBlank(message = "Name is required")
    @Size(min = 3 , message = "Must be longer then 3 letters")
    private String name;


    /**
     * Cascade.Persist: means whenever i am going to save a the class pojo
     * save the person and class in a single operation.
     * we dont want any more cascade efffects for any other operatiions such as delete and update
     * e.g: if we delete a class we dont want the 'Persons' assiocated with that class to be deleted
     * JenkinsClass can have multiple person's so we need to ude some type of collections object
     * mappedby: tells spring that the person class is mapped by the class 'JenkinsClass'
     */
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, targetEntity = Developer.class)
    @ToString.Exclude //to avoid cicrular dependency stakover flow
    Set<Developer> developerList = new HashSet<>();


}
