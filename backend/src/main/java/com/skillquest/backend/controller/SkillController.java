package com.skillquest.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skillquest.backend.dto.skilldtos.SkillSummaryDto;
import com.skillquest.backend.model.User;
import com.skillquest.backend.service.SkillService;
import com.skillquest.backend.service.UserService;

@RestController 
@RequestMapping("/api/skills")
public class SkillController {
    private final SkillService skillService;
    private final UserService userService;

    public SkillController(SkillService skillService, UserService userService) {
        this.skillService = skillService;
        this.userService = userService;
    }

    @GetMapping("/browse")
    @ResponseStatus(HttpStatus.OK)
    public List<SkillSummaryDto> getBrowseSkills(
        Authentication authentication,
        @RequestParam(defaultValue = "10") int limit
    ) {
        User user = userService.getUser(authentication.getName());
        Long userId = user.getId();
        return skillService.getBrowseSkills(userId, limit);
    }
}
