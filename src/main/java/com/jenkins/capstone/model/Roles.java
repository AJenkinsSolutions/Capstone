package com.jenkins.capstone.model;

import com.jenkins.capstone.audit.AuditEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class Roles extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int roleId;


    private String roleName;
}
