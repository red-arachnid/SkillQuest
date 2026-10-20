package com.skillquest.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skillquest.backend.dto.skilldtos.StartSkillRequest;
import com.skillquest.backend.dto.skilldtos.UserSkillSummaryDto;
import com.skillquest.backend.service.UserSkillService;

@RestController 
@RequestMapping("/api/user-skills")
public class UserSkillController {
    private final UserSkillService userSkillService;

    public UserSkillController(UserSkillService userSkillService) {
        this.userSkillService = userSkillService;
    }

    @PostMapping ("/start")
    @ResponseStatus(HttpStatus.CREATED)
    public void startSkill(Authentication authentication, @RequestBody StartSkillRequest request) {
        userSkillService.startLearningSkill(authentication.getName(), request);
    }

    @GetMapping("/my-learning")
    @ResponseStatus(HttpStatus.OK)
    public List<UserSkillSummaryDto> myLearning(Authentication authentication) {
        return userSkillService.getAllSkillOfUser(authentication.getName());
    }
}
