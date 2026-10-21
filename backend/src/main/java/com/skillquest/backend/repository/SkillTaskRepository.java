package com.skillquest.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skillquest.backend.dto.skillmoduledtos.SkillTaskProjection;
import com.skillquest.backend.model.SkillTask;

public interface SkillTaskRepository extends JpaRepository<SkillTask, Long> {
    
    @Query ("""
        SELECT st AS skillTask, 
            ut.done AS isDone,
            ut.completedAt as completedAt, 
            rs AS resource
        FROM  SkillTask st
        LEFT JOIN Resource rs ON rs.task = st
        LEFT JOIN UserTask ut ON ut.task = st AND ut.userSkill.user.id = :userId
        WHERE st.module.id = :skillModuleId 
        ORDER BY st.position ASC
        """)
    List<SkillTaskProjection> getTasksBySkillModuleId(@Param("userId") Long userId ,@Param("skillModuleId") Long skillModuleId);
}
