package com.skillquest.backend.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.skillquest.backend.exception.ApiException;
import com.skillquest.backend.model.SkillTask;
import com.skillquest.backend.model.User;
import com.skillquest.backend.model.UserSkill;
import com.skillquest.backend.model.UserTask;
import com.skillquest.backend.repository.SkillTaskRepository;
import com.skillquest.backend.repository.UserRepository;
import com.skillquest.backend.repository.UserSkillRepository;
import com.skillquest.backend.repository.UserTaskRepository;

@Service 
public class UserTaskService {
    private final UserTaskRepository userTaskRepository;
    private final SkillTaskRepository skillTaskRepository;
    private final UserSkillRepository userSkillRepository;
    private final UserRepository userRepository;

    public UserTaskService(
        UserTaskRepository userTaskRepository, 
        UserRepository userRepository,
        SkillTaskRepository skillTaskRepository,
        UserSkillRepository userSkillRepository
    ) {
        this.userTaskRepository = userTaskRepository;
        this.userRepository = userRepository;
        this.skillTaskRepository = skillTaskRepository;
        this.userSkillRepository = userSkillRepository;
    }

    public void addUserTask(String userEmail, Long taskId, Long skillId) {
        User user = userRepository.findByEmail(userEmail)
            .orElseThrow(() -> new ApiException(HttpStatus.UNAUTHORIZED, "User no longer exists"));
        
        SkillTask task = skillTaskRepository.getReferenceById(taskId);
        UserSkill userSkill = userSkillRepository.findByUserIdAndSkillId(user.getId(), skillId)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "The skill type does not exist"));

        UserTask newUserTask = new UserTask();
        newUserTask.setUserSkill(userSkill);
        newUserTask.setTask(task);
        newUserTask.setDone(true);

        userTaskRepository.save(newUserTask);
    }
}
