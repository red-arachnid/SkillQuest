package com.skillearn.backend.dto;

public record AuthResponse(String token, UserResponse user) {}
