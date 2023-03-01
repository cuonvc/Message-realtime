package com.project.message.messagerealtime.model.dto;

import com.project.message.messagerealtime.utils.enumaration.MessageType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MessageDTO extends CommonDTO {

    @NotNull
    @NotBlank
    private String content;

    private MessageType messageType;

    private UserDTO userDTO;

    private ConversationDTO conversationDTO;
}
