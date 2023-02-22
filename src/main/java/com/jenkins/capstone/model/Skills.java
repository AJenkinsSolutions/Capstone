package com.jenkins.capstone.model;

import com.jenkins.capstone.audit.AuditEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class Skills extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int skillsId;

    @NotBlank(message = "Language is required")
    private String language;

    @Column(name = "front_end")
    private boolean frontEnd;

    @Column(name = "back_end")
    private boolean backEnd;

    //This field is not required
    private String ide;
}
