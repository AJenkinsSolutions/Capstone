package com.jenkins.capstone.model;

import com.jenkins.capstone.audit.AuditEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class Skills extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int skillId;

    @NotBlank(message = "Language is required")
    private String language;

    @NotBlank(message = "Specify if front End development is in your skill set")
    private boolean frontEnd;

    @NotBlank(message = "Specify if backEnd development is in your skill set")
    private boolean backEnd;

    //This field is not required
    private String ide;
}
