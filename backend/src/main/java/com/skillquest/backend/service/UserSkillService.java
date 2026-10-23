package com.skillquest.backend.service;

import java.time.Instant;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.skillquest.backend.dto.skilldtos.StartSkillRequest;
import com.skillquest.backend.dto.skilldtos.UserSkillSummaryDto;
import com.skillquest.backend.exception.ApiException;
import com.skillquest.backend.model.Skill;
import com.skillquest.backend.model.User;
import com.skillquest.backend.model.UserSkill;
import com.skillquest.backend.model.enums.SkillStatus;
import com.skillquest.backend.repository.SkillRepository;
import com.skillquest.backend.repository.UserRepository;
import com.skillquest.backend.repository.UserSkillRepository;

@Service 
public class UserSkillService {
    private final UserSkillRepository userSkillRepository;
    private final UserService userService;
    private final SkillRepository skillRepository;

    public  UserSkillService(UserSkillRepository userSkillRepository, UserService userService, SkillRepository skillRepository) {
        this.userSkillRepository = userSkillRepository;
        this.userService = userService;
        this.skillRepository = skillRepository;
    }

    public void startLearningSkill(String userEmail, StartSkillRequest request) {
        User user = userService.getUser(userEmail);
        
        if (userSkillRepository.existsByUserIdAndSkillId(user.getId(), request.skillId())) {
            throw new ApiException(HttpStatus.BAD_REQUEST , "User is already learning or has completed this skill.");
        }

        Skill skill = skillRepository.getReferenceById(request.skillId());

        UserSkill userSkill = new UserSkill();
        userSkill.setUser(user);
        userSkill.setSkill(skill);
        userSkill.setStatus(SkillStatus.ACTIVE);

        userSkillRepository.save(userSkill);
    }

    public List<UserSkillSummaryDto> getAllSkillOfUser(String userEmail) {
        User user = userService.getUser(userEmail);

        return userSkillRepository.getAllSkillsOfUser(user.getId())
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
