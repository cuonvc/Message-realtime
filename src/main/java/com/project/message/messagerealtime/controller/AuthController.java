package com.project.message.messagerealtime.controller;

import com.project.message.messagerealtime.model.dto.UserDTO;
import com.project.message.messagerealtime.model.payload.AuthenticationRequest;
import com.project.message.messagerealtime.model.payload.JwtAuthResponse;
import com.project.message.messagerealtime.model.payload.RegisterRequest;
import com.project.message.messagerealtime.security.JwtTokenProvider;
import com.project.message.messagerealtime.service.AuthService;
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

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final PasswordEncoder passwordEncoder;

    @PostMapping("/form/signup")
    public ResponseEntity<?> registerForm(@RequestBody @Valid RegisterRequest request) {
        authService.register(request);
        return new ResponseEntity<>("Register successfully!", HttpStatus.CREATED);
    }

    @PostMapping("/form/login")
    public ResponseEntity<JwtAuthResponse> loginForm(@RequestBody AuthenticationRequest request) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmailOrPhoneNumber(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtTokenProvider.generateToken(authentication);

        return new ResponseEntity<>(new JwtAuthResponse(jwtToken), HttpStatus.OK);
    }

}
