package com.skillquest.backend.service;

import java.time.Instant;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.skillquest.backend.dto.skillmoduledtos.ResourceResponseDto;
import com.skillquest.backend.dto.skillmoduledtos.SkillModuleResponse;
import com.skillquest.backend.dto.skillmoduledtos.TaskResponseDto;
import com.skillquest.backend.exception.ApiException;
import com.skillquest.backend.model.Resource;
import com.skillquest.backend.model.SkillTask;
import com.skillquest.backend.model.User;
import com.skillquest.backend.repository.SkillModuleRepository;
import com.skillquest.backend.repository.SkillTaskRepository;
import com.skillquest.backend.repository.UserRepository;

@Service 
public class SkillModuleService {
    private final SkillModuleRepository skillModuleRepository;
    private final SkillTaskRepository skillTaskRepository;
    private final UserService userService;

    public SkillModuleService(
        SkillModuleRepository skillModuleRepository, 
        SkillTaskRepository skillTaskRepository,
        UserService userService
    ) {
        this.skillModuleRepository = skillModuleRepository;
        this.skillTaskRepository = skillTaskRepository;
        this.userService = userService;
    }

    public List<SkillModuleResponse> getSkillModulesOfSkill(String userEmail, Long skillId) {
        User user = userService.getUser(userEmail);

        return skillModuleRepository.getSkillModulesBySkillId(skillId)
        .stream().map(skillModule -> {
            List<TaskResponseDto> tasks = skillTaskRepository.getTasksBySkillModuleId(user.getId(), skillModule.getId())
                    .stream().map(projection -> {
                        SkillTask skillTask = projection.getSkillTask();
                        boolean isDone = projection.getIsDone() != null ? projection.getIsDone() : false;
                        Instant completedAt = projection.getCompletedAt() != null ? projection.getCompletedAt() : null;
                        Resource resource = projection.getResource();
                        
                        ResourceResponseDto resourceDto = null;
                        if (resource != null) {
                            resourceDto = new ResourceResponseDto(
                                resource.getId(),
                                resource.getTitle(),
                                resource.getUrl(),
                                resource.isFree()
                            );
                        }

                        return new TaskResponseDto(
                            skillTask.getId(),
                            skillTask.getTitle(),
                            skillTask.getDescription(),
                            skillTask.getEstMinutes(),
                            skillTask.getFormat(),
                            skillTask.getTaskXp(),
                            isDone,
                            completedAt,
                            resourceDto
                        );
                    }).toList();

            return new SkillModuleResponse(
                skillModule.getId(),
                skillModule.getTitle(),
                tasks
            );
        }).toList();
    }
}
