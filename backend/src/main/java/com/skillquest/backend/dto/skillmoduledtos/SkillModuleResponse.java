package com.skillquest.backend.dto.skillmoduledtos;

import java.util.List;

public record SkillModuleResponse(
    Long id,
    String title,
    List<TaskResponseDto> tasks
) {}
