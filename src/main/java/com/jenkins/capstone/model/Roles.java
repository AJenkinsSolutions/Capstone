package com.jenkins.capstone.model;

import com.jenkins.capstone.audit.AuditEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Entity
public class Roles extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int roleId;


    private String roleName;


}
