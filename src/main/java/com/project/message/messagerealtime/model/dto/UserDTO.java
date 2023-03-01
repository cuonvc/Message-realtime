package com.project.message.messagerealtime.model.dto;

import com.project.message.messagerealtime.anotation.PhoneNumberValid;
import com.project.message.messagerealtime.model.entity.Conversation;
import com.project.message.messagerealtime.model.entity.Message;
import com.project.message.messagerealtime.utils.enumaration.Gender;
import com.project.message.messagerealtime.utils.enumaration.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserDTO extends CommonDTO {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 10, message = "firstName must be minimum 3 characters and maximum 10 characters")
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 10, message = "lastName must be minimum 3 characters and maximum 10 characters")
    private String lastName;

    @Email
    private String email;

    @PhoneNumberValid(message = "PhoneNumber must be region Vietnam")
    private String phoneNumber;

    private Gender gender;

    private String avatar;

    private Role isRoot = Role.IS_MEMBER;

    private Set<ConversationDTO> conversationDTOS = new HashSet<>();

    private Set<MessageDTO> messageDTOS = new HashSet<>();

}
