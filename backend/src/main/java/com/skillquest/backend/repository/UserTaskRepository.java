package com.skillquest.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skillquest.backend.model.UserTask;

public interface UserTaskRepository extends JpaRepository<UserTask, Long> {
    
}
