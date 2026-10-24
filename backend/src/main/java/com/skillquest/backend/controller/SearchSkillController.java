package com.skillquest.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skillquest.backend.dto.skilldtos.SkillSummaryDto;
import com.skillquest.backend.service.SearchSkillService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController 
@RequestMapping("/api/search")
public class SearchSkillController {
    private final SearchSkillService searchSkillService;

    public SearchSkillController(SearchSkillService searchSkillService) {
        this.searchSkillService = searchSkillService;
    }


    @GetMapping("/skill/{skillname}")
    @ResponseStatus(HttpStatus.OK)
    public List<SkillSummaryDto> getSkillBySkillSlug(Authentication authentication, @PathVariable String skillname) {
        return searchSkillService.getSkillsBySkillSlug(authentication.getName(), skillname);
    }
}
