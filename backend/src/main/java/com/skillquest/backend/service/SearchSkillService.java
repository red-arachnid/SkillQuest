package com.skillquest.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillquest.backend.dto.skilldtos.SkillSummaryDto;
import com.skillquest.backend.model.Skill;
import com.skillquest.backend.model.User;
import com.skillquest.backend.model.enums.SkillStatus;
import com.skillquest.backend.repository.SkillRepository;

@Service 
public class SearchSkillService {
    private final UserService userService;
    private final SkillRepository skillRepository;

    public SearchSkillService(
        UserService userService,
        SkillRepository skillRepository
    ) {
        this.userService = userService;
        this.skillRepository = skillRepository;
    }

    public List<SkillSummaryDto> getSkillsBySkillSlug(String useremail, String skillSlug) {
        User user = userService.getUser(useremail);

        String formattedSearchTerm = skillSlug.trim().replace(" ", "-");

        return skillRepository.findSkillBySkillName(user.getId(), formattedSearchTerm)
            .stream().map(projection -> {
                Skill skill = projection.getSkill();
                SkillStatus status = projection.getStatus();
                int skillXp = projection.getSkillXp();
                int doneTasks = projection.getDoneTasks() != null ? projection.getDoneTasks() : 0;
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
