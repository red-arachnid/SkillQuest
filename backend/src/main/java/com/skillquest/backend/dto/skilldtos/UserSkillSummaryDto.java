package com.skillquest.backend.dto.skilldtos;

import java.time.Instant;

import com.skillquest.backend.model.enums.Difficulty;
import com.skillquest.backend.model.enums.SkillStatus;

public record UserSkillSummaryDto(
    Long id,
    Long skillId,
    String slug,
    String name,
    String category,
    String description,
    String icon,
    Difficulty difficulty,
    int estimatedHours,
    SkillStatus status,
    Instant startedAt,
    Instant completedAt,
    Integer doneTasks,
    Integer totalTasks
) {}
