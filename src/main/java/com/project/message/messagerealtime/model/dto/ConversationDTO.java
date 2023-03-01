package com.project.message.messagerealtime.model.dto;

import com.project.message.messagerealtime.utils.enumaration.ConversationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class ConversationDTO extends CommonDTO {

    @NotNull
    @NotBlank
    @Size(min = 1, max = 30, message = "Conversation name must be minimum 1 character and maximum 30 characters")
    private String title;

    private String background;

    private ConversationType conversationType;

    private Set<UserDTO> userDTOS = new HashSet<>();

    private Set<MessageDTO> messageDTOS = new HashSet<>();
}
