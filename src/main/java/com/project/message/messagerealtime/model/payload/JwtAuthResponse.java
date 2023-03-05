package com.project.message.messagerealtime.model.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class JwtAuthResponse {

    private String accessToken;

    private String tokenType = "Bearer";

    public JwtAuthResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
