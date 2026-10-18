package com.skillquest.backend.dto.skilldtos;

import com.skillquest.backend.model.enums.Difficulty;

public record SkillSummaryDto(
    Long id,
    String slug,
    String name,
    String category,
    String description,
    String icon,
    Difficulty difficulty,
    int estimatedHours,
    String status,
    int doneTasks,
    int totalTasks
) {}
