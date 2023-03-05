package com.project.message.messagerealtime.model.payload;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String emailOrPhoneNumber;

    private String password;

}
