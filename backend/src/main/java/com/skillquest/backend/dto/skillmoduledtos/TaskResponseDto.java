package com.skillquest.backend.dto.skillmoduledtos;

import java.time.Instant;

import com.skillquest.backend.model.enums.TaskFormat;

public record TaskResponseDto(
    Long id,
    String title,
    String description,
    int estimatedMinutes,
    TaskFormat format,
    int taskXp,
    boolean isDone,
    Instant completedAt,
    ResourceResponseDto resource
) {}
