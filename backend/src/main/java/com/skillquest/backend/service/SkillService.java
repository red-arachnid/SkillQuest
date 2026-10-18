package com.skillquest.backend.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.skillquest.backend.dto.skilldtos.SkillSummaryDto;
import com.skillquest.backend.model.enums.SkillStatus;
import com.skillquest.backend.repository.SkillRepository;

@Service 
public class SkillService {
    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<SkillSummaryDto> getBrowseSkills(Long userId, int limit) {
        Pageable pageable = PageRequest.of(0, limit);

        return skillRepository.findAvailabeSkillsForUser(
            userId,
            SkillStatus.COMPLETED,
            pageable
        )
        .stream()
        .map(skill -> new SkillSummaryDto(
            skill.getId(),
            skill.getSlug(),
            skill.getName(),
            skill.getCategory(),
            skill.getDescription(),
            skill.getIcon(),
            skill.getDifficulty(),
            skill.getEstimatedHours()
        ))
        .toList();
    }
}
