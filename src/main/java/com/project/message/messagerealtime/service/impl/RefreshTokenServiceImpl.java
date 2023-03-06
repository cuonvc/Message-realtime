package com.project.message.messagerealtime.service.impl;

import com.project.message.messagerealtime.exception.ResourceNotFoundException;
import com.project.message.messagerealtime.model.entity.RefreshToken;
import com.project.message.messagerealtime.model.entity.User;
import com.project.message.messagerealtime.model.payload.AuthenticationRequest;
import com.project.message.messagerealtime.model.payload.RefreshTokenRequest;
import com.project.message.messagerealtime.model.payload.RefreshTokenResponse;
import com.project.message.messagerealtime.repository.RefreshTokenRepository;
import com.project.message.messagerealtime.security.JwtTokenProvider;
import com.project.message.messagerealtime.service.RefreshTokenService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    private final JwtTokenProvider jwtTokenProvider;

    private final AuthenticationManager authenticationManager;

    @Value("${app.refresh-token.expiration-milliseconds}")
    private long refreshTokenExpireOnMs;

    @Override
    public RefreshToken initialEntity(User user) {
        return refreshTokenRepository.save(RefreshToken.builder()
                        .user(user).build());
    }

    @Override
    public RefreshToken updateRefreshToken(AuthenticationRequest request) {
        RefreshToken refreshToken = refreshTokenRepository.findByUsername(request.getEmailOrPhoneNumber())
                .orElseThrow(() -> new ResourceNotFoundException("Refresh token", "email or phone", request.getEmailOrPhoneNumber()));

        Date currentDate = new Date();
        refreshToken = refreshToken.toBuilder()
                .token("refresh_" + UUID.randomUUID().toString().replaceAll("-", ""))
                .expireDate(new Date(currentDate.getTime() + refreshTokenExpireOnMs))
                .modifiedDate(LocalDateTime.now())
                .build();
        return refreshTokenRepository.save(refreshToken);
    }

    @Override
    public RefreshTokenResponse refreshAccessToken(RefreshTokenRequest request) {
        RefreshToken refreshTokenObject = refreshTokenRepository.findByTokenRefresh(request.getRefreshToken(), new Date())
                .orElseThrow(() -> new ResourceNotFoundException("Refresh token", "token", request.getRefreshToken()));

        String username = "";
        try {
            username = refreshTokenObject.getUser().getEmail();
        } catch (Exception e) {
            username = refreshTokenObject.getUser().getPhoneNumber();
        }

        return RefreshTokenResponse.builder()
                .accessToken(jwtTokenProvider.generateToken(username))
                .build();
    }
}
