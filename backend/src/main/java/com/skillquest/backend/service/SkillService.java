package com.skillquest.backend.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.skillquest.backend.dto.skilldtos.SkillSummaryDto;
import com.skillquest.backend.model.Skill;
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
        .map(projection -> {
            Skill skill = projection.getSkill();
            SkillStatus status = projection.getStatus();
            int skillXp = projection.getSkillXp();
            int doneTasks = projection.getDoneTasks() != null ? projection.getDoneTasks() : null;
            int totalTasks = projection.getTotalTasks();

            return new SkillSummaryDto(
                skill.getId(),
                skill.getSlug(),
                skill.getName(),
                skill.getCategory(),
                skill.getDescription(),
                skill.getIcon(),
                skill.getDifficulty(),
                skill.getEstimatedHours(),
                status,
                skillXp,
                doneTasks,
                totalTasks
            );
        }).toList();
    }
}
