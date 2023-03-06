package com.project.message.messagerealtime.model.payload;

import com.project.message.messagerealtime.utils.enumaration.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class RefreshTokenResponse {

    private String accessToken;

    private String tokenType = "Bearer";

    private String refreshToken;

}
