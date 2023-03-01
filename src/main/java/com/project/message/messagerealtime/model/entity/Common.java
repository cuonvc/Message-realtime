package com.project.message.messagerealtime.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class Common {

    @Id
    @GenericGenerator(name = "custom_id", strategy = "com.project.message.messagerealtime.constraint.CustomIdGenerator")
    @GeneratedValue(generator = "custom_id")
    private String id;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "is_deleted")
    private boolean isDeleted = Boolean.FALSE;

}
