package com.skillquest.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skillquest.backend.dto.UserTaskCompletedRequest;
import com.skillquest.backend.service.UserTaskService;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("/api/user-task")
public class UserTaskController {
    private final UserTaskService userTaskService;

    public UserTaskController(UserTaskService userTaskService) {
        this.userTaskService = userTaskService;
    }

    @PostMapping("/complete")
    @ResponseStatus(HttpStatus.CREATED)
    public void postMethodName(Authentication authentication, @RequestBody UserTaskCompletedRequest request) {
        userTaskService.addUserTask(authentication.getName(), request.taskId(), request.skillId());
    }
    
}
