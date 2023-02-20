package com.jenkins.capstone.model;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

/**
 * This class holds data that will be common amoung multiple pojos, so we can reduce code
 * MappedSuperClass: says whenever there are pojos that extend this class please treat the feilds in here as
 * columns within there table
 * @EntityListener(): Tells spring to treat this class an entity that supports auditing
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class CoreEntity {

    /**
     * Get date created and create by who
     * will assist auditing later
     * We are telling spring to not consider these columns for updates
     * @Date: 02/20/23
     * @Version: SnapShot 1
     * @Capstone
     */
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;


    /**
     * We want to know when and who updated it
     * @Date: 02/20/23
     * @Version: SnapShot 1
     * @Capstone
     */
    @LastModifiedDate
    @Column
    private LocalDateTime updatedAt;


}
