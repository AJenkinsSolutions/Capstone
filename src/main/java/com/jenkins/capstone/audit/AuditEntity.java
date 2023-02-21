package com.jenkins.capstone.audit;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * This class holds data that will be common amoung multiple pojos, so we can reduce code
 * MappedSuperClass: tells spring that this is just a superclass not a table
 * @EntityListener(): Tells spring to treat this class an entity that supports auditing
 * Tells us when ever a entity is created updated etc
 *  @Date: 02/20/23
 * @Version: SnapShot 1
 * @Capstone
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditEntity {

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
    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(insertable = false)
    private String updateBy;

}
