package com.skillquest.backend.dto;

public record UserResponse(
    Long id, 
    String name, 
    String email, 
    int userXp,
    int currentStreak,
    Long lastActiveSkill
) {}
