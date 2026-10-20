package com.skillquest.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skillquest.backend.dto.skilldtos.UserSkillSummaryProjection;
import com.skillquest.backend.model.UserSkill;

public interface UserSkillRepository extends JpaRepository<UserSkill, Long>{
    boolean existsByUserIdAndSkillId(Long userId, Long skillId);

    @Query ("""
        SELECT 
            us.id AS id,
            us.skill AS skill,
            us.status AS status,
            us.startedAt AS startedAt,
            us.completedAt AS completedAt,
            (
                SELECT COUNT(st) FROM SkillModule sm
                JOIN SkillTask st ON st.module = sm
                WHERE sm.skill = us.skill
            ) AS totalTasks,
            (
                SELECT COUNT(ut) FROM UserTask ut
                JOIN ut.task t
                JOIN t.module sm
                WHERE sm.skill = us.skill AND ut.userSkill = us AND ut.done = true
            ) AS doneTasks
            FROM UserSkill us
            WHERE us.user.id = :userId 
            ORDER BY us.startedAt DESC        
        """)
    List<UserSkillSummaryProjection> getAllSkillsOfUser(
        @Param("userId") Long userId
    );
}
