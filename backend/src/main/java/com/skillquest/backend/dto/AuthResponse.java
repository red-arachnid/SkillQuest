package com.skillquest.backend.dto;

public record AuthResponse(String token, UserResponse user) {}
