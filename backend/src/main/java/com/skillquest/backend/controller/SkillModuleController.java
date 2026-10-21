package com.skillquest.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skillquest.backend.dto.skillmoduledtos.SkillModuleResponse;
import com.skillquest.backend.service.SkillModuleService;

@RestController 
@RequestMapping("/api/skill-module")
public class SkillModuleController {
    private final SkillModuleService skillModuleService;

    public SkillModuleController(SkillModuleService skillModuleService) {
        this.skillModuleService = skillModuleService;
    }


    @GetMapping("/{skillId}")
    @ResponseStatus(HttpStatus.OK)
    public List<SkillModuleResponse> getSkillModule(Authentication authentication, @PathVariable Long skillId) {
        return skillModuleService.getSkillModulesOfSkill(authentication.getName(), skillId);
    }
}
