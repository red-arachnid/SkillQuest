package com.skillquest.backend.dto.skillmoduledtos;

import java.time.Instant;

import com.skillquest.backend.model.Resource;
import com.skillquest.backend.model.SkillTask;

public interface SkillTaskProjection {
    SkillTask getSkillTask();
    Boolean getIsDone();
    Instant getCompletedAt();
    Resource getResource();
}
