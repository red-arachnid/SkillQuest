package com.skillquest.backend.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.skillquest.backend.dto.skilldtos.StartSkillRequest;
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
    private final UserRepository userRepository;
    private final SkillRepository skillRepository;

    public  UserSkillService(UserSkillRepository userSkillRepository, UserRepository userRepository, SkillRepository skillRepository) {
        this.userSkillRepository = userSkillRepository;
        this.userRepository = userRepository;
        this.skillRepository = skillRepository;
    }

    public void startLearningSkill(String userEmail, StartSkillRequest request) {
        User user = userRepository.findByEmail(userEmail)
            .orElseThrow(() -> new ApiException(HttpStatus.UNAUTHORIZED, "User no longer exists"));
        
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
}
