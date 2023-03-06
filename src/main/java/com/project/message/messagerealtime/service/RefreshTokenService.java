package com.project.message.messagerealtime.service;

import com.project.message.messagerealtime.model.entity.RefreshToken;
import com.project.message.messagerealtime.model.entity.User;
import com.project.message.messagerealtime.model.payload.AuthenticationRequest;
import com.project.message.messagerealtime.model.payload.RefreshTokenRequest;
import com.project.message.messagerealtime.model.payload.RefreshTokenResponse;

public interface RefreshTokenService {

    RefreshToken initialEntity(User user);

    RefreshToken updateRefreshToken(AuthenticationRequest request);

    RefreshTokenResponse refreshAccessToken(RefreshTokenRequest request);

}
