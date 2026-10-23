package com.skillquest.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillquest.backend.dto.HeatmapResponse;
import com.skillquest.backend.service.ActivityLogService;
import com.skillquest.backend.service.UserService;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;


@RestController 
@RequestMapping("/api/activity")
public class ActivityController {
    private final ActivityLogService activityLogService;

    public ActivityController(ActivityLogService activityLogService, UserService userService) {
        this.activityLogService = activityLogService;
    }

    @GetMapping("/heatmap")
    public List<HeatmapResponse> getHeatmapData(Authentication authentication) {
        return activityLogService.getHeatmapData(authentication.getName());
    }
    
}
