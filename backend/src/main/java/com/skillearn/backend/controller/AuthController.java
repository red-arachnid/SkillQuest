package com.skillearn.backend.controller;

import com.skillearn.backend.dto.*;
import com.skillearn.backend.service.AuthService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController 
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED) 
    public UserResponse signup(@Valid @RequestBody SignupRequest request) {
        return authService.signup(request);
    }    
}
