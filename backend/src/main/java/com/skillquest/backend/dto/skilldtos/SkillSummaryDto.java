package com.skillquest.backend.dto.skilldtos;

import com.skillquest.backend.model.enums.Difficulty;
import com.skillquest.backend.model.enums.SkillStatus;

public record SkillSummaryDto(
    Long id,
    String slug,
    String name,
    String category,
    String description,
    String icon,
    Difficulty difficulty,
    int estimatedHours,
    SkillStatus status,
    int skillXp,
    int doneTasks,
    int totalTasks
) {}
