package com.skillquest.backend.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skillquest.backend.dto.skilldtos.SkillSummaryProjection;
import com.skillquest.backend.model.Skill;
import com.skillquest.backend.model.enums.SkillStatus;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    
    @Query ("""
        SELECT s AS skill, us.status AS status, (
            SELECT COUNT(st) FROM SkillModule sm
            JOIN SkillTask st ON st.module = sm
            WHERE sm.skill = s
        ) AS totalTasks, (
            SELECT COUNT(ut) FROM UserTask ut
            JOIN ut.task t
            JOIN t.module sm
            WHERE sm.skill = s AND ut.userSkill.user.id = :userId AND ut.done = true
        ) AS doneTasks
        FROM Skill s
        LEFT JOIN UserSkill us ON us.skill = s AND us.user.id = :userId
        WHERE (us.status IS NULL OR us.status <> :excludedStatus)
        ORDER BY s.id ASC
        """)
    List<SkillSummaryProjection> findAvailabeSkillsForUser(
        @Param("userId") Long userId,
        @Param("excludedStatus") SkillStatus excludedStatus,
        Pageable pageable
    );
}