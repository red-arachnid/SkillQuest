package com.skillquest.backend.dto.skilldtos;

import java.time.Instant;

import com.skillquest.backend.model.Skill;
import com.skillquest.backend.model.enums.SkillStatus;

public interface UserSkillSummaryProjection {
    Long getId();
    Skill getSkill();
    SkillStatus getStatus();
    Instant getStartedAt();
    Instant getCompletedAt();
    Integer getTotalTasks();
    Integer getDoneTasks();
}
