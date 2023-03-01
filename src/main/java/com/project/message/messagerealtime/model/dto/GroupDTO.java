package com.project.message.messagerealtime.model.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class GroupDTO extends ConversationDTO {

    @Size(min = 2)
    private Integer numberOfMembers;

    private String groupPhoto;
}
