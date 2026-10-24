package com.skillquest.backend.service;

import java.time.Instant;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skillquest.backend.dto.skilldtos.SkillSummaryDto;
import com.skillquest.backend.dto.skilldtos.UserSkillSummaryDto;
import com.skillquest.backend.model.Skill;
import com.skillquest.backend.model.User;
import com.skillquest.backend.model.enums.SkillStatus;
import com.skillquest.backend.repository.SkillRepository;
import com.skillquest.backend.repository.UserSkillRepository;

@Service 
public class SearchSkillService {
    private final UserService userService;
    private final SkillRepository skillRepository;
    private final UserSkillRepository userSkillRepository;

    public SearchSkillService(
        UserService userService,
        SkillRepository skillRepository,
        UserSkillRepository userSkillRepository
    ) {
        this.userService = userService;
        this.skillRepository = skillRepository;
        this.userSkillRepository = userSkillRepository;
    }

    public List<SkillSummaryDto> getSkillsBySkillSlug(String useremail, String skillSlug) {
        User user = userService.getUser(useremail);

        String formattedSearchTerm = skillSlug.trim().replace(" ", "-");

        return skillRepository.findSkillsBySkillName(user.getId(), formattedSearchTerm)
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

    public List<UserSkillSummaryDto> getUserSkillBySkillSlug(String useremail, String skillSlug) {
        User user = userService.getUser(useremail);

        String formattedSearchTerm = skillSlug.trim().replace(" ", "-");

        return userSkillRepository.findUserSkillsBySkillName(user.getId(), formattedSearchTerm)
            .stream().map(projection -> {
                Long id = projection.getId();
                Skill skill = projection.getSkill();
                SkillStatus status = projection.getStatus();
                Instant startedAt = projection.getStartedAt();
                Instant completedAt = projection.getCompletedAt();
                int doneTasks = projection.getDoneTasks() != null ? projection.getDoneTasks() : 0;
                int totalTasks = projection.getTotalTasks();

                return new UserSkillSummaryDto(
                    id,
                    skill.getId(),
                    skill.getSlug(),
                    skill.getName(),
                    skill.getCategory(),
                    skill.getDescription(),
                    skill.getIcon(),
                    skill.getDifficulty(),
                    skill.getEstimatedHours(),
                    status,
                    startedAt,
                    completedAt,
                    doneTasks,
                    totalTasks
                );
            }).toList();
    }
}
