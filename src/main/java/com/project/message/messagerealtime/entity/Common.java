package com.project.message.messagerealtime.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class Common {

    @Id
    @GeneratedValue(generator = "custom_id")
    @GenericGenerator(name = "custom_id", strategy = "com.project.message.messagerealtime.constraint.CustomIdGenerator")
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
