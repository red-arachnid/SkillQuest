package com.skillquest.backend.dto.skilldtos;

import com.skillquest.backend.model.Skill;
import com.skillquest.backend.model.enums.SkillStatus;

public interface SkillSummaryProjection {
    Skill getSkill();
    SkillStatus getStatus();
    Integer getDoneTasks();
    Integer getTotalTasks();
}
