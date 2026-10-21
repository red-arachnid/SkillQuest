package com.skillquest.backend.dto.skillmoduledtos;

import java.time.Instant;

public record TaskResponseDto(
    Long id,
    String title,
    String description,
    int estimatedMinutes,
    int taskXp,
    boolean isDone,
    Instant completedAt,
    ResourceResponseDto resource
) {}
