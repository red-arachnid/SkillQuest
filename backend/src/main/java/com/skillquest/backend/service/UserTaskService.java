package com.skillquest.backend.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.skillquest.backend.exception.ApiException;
import com.skillquest.backend.model.SkillTask;
import com.skillquest.backend.model.User;
import com.skillquest.backend.model.UserSkill;
import com.skillquest.backend.model.UserTask;
import com.skillquest.backend.repository.SkillTaskRepository;
import com.skillquest.backend.repository.UserSkillRepository;
import com.skillquest.backend.repository.UserTaskRepository;

import jakarta.transaction.Transactional;

@Service 
public class UserTaskService {
    private final UserTaskRepository userTaskRepository;
    private final SkillTaskRepository skillTaskRepository;
    private final UserSkillRepository userSkillRepository;
    private final UserService userService;
    private final ActivityLogService activityLogService;

    public UserTaskService(
        UserTaskRepository userTaskRepository, 
        SkillTaskRepository skillTaskRepository,
        UserSkillRepository userSkillRepository,
        UserService userService,
        ActivityLogService activityLogService
    ) {
        this.userTaskRepository = userTaskRepository;
        this.skillTaskRepository = skillTaskRepository;
        this.userSkillRepository = userSkillRepository;
        this.userService = userService;
        this.activityLogService = activityLogService;
    }

    @Transactional 
    public void addUserTask(String userEmail, Long taskId, Long skillId) {
        User user = userService.getUser(userEmail);
        
        UserSkill userSkill = userSkillRepository.findByUserIdAndSkillId(user.getId(), skillId)
            .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "The skill type does not exist"));

        if (userTaskRepository.existsByUserSkillIdAndTaskId(userSkill.getId(), taskId)) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Task already marked as completed");
        }

        SkillTask task = skillTaskRepository.findById(taskId)
            .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Task not found"));

        UserTask newUserTask = new UserTask();
        newUserTask.setUserSkill(userSkill);
        newUserTask.setTask(task);
        newUserTask.setDone(true);
        userTaskRepository.save(newUserTask);

        int earnedXp = task.getTaskXp();
        user.setUserXp(user.getUserXp() + earnedXp);

        activityLogService.logDayActivity(user);
    }
}
