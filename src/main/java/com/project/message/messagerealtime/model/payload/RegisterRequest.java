package com.project.message.messagerealtime.model.payload;

import com.project.message.messagerealtime.anotation.PhoneNumberValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegisterRequest {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 10, message = "firstName must be minimum 3 characters and maximum 10 characters")
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 10, message = "lastName must be minimum 3 characters and maximum 10 characters")
    private String lastName;

    @NotNull
    @NotBlank
    @Email
    private String email;

    @PhoneNumberValid(message = "Phone number must be region Vietnam")
    private String phoneNumber;

    @NotNull
    @NotBlank
    @Size(min = 8, max = 20, message = "Password must be minimum 8 characters and maximum 20 characters")
    private String password;

    private LocalDateTime registerDate;
}
