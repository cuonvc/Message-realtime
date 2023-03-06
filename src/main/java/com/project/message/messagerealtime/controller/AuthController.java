package com.project.message.messagerealtime.controller;

import com.project.message.messagerealtime.model.dto.UserDTO;
import com.project.message.messagerealtime.model.payload.*;
import com.project.message.messagerealtime.repository.RefreshTokenRepository;
import com.project.message.messagerealtime.security.JwtTokenProvider;
import com.project.message.messagerealtime.service.AuthService;
import com.project.message.messagerealtime.service.RefreshTokenService;
import com.project.message.messagerealtime.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    private final RefreshTokenService refreshTokenService;

    private final RefreshTokenRepository refreshTokenRepository;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/form/signup")
    public ResponseEntity<?> registerForm(@RequestBody @Valid RegisterRequest request) {
        authService.register(request);
        return new ResponseEntity<>("Register successfully!", HttpStatus.CREATED);
    }

    @PostMapping("/form/login")
    public ResponseEntity<RefreshTokenResponse> loginForm(@RequestBody AuthenticationRequest request) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmailOrPhoneNumber(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtAccessToken = jwtTokenProvider.generateToken(authentication.getName());

        String newRefreshToken = refreshTokenService.updateRefreshToken(request).getToken();

        return new ResponseEntity<>(new RefreshTokenResponse(jwtAccessToken, "Bearer", newRefreshToken), HttpStatus.OK);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<RefreshTokenResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest request) {
        RefreshTokenResponse response = refreshTokenService.refreshAccessToken(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
