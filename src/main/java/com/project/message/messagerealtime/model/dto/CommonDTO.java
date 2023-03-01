package com.project.message.messagerealtime.model.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class CommonDTO {

    private String id;

    private LocalDateTime createdDate;

    private String createdBy;

    private LocalDateTime modifiedDate;

    private String modifiedBy;

    private boolean isDeleted = Boolean.FALSE;

}
