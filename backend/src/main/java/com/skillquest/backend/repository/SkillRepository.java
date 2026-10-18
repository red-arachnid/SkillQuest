package com.skillquest.backend.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skillquest.backend.model.Skill;
import com.skillquest.backend.model.enums.SkillStatus;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    
    @Query ("""
        SELECT s FROM Skill s
        WHERE NOT EXISTS (
            SELECT us FROM UserSkill us
            WHERE us.skill = s
                AND us.user.id = :userId
                AND us.status = :excludedStatus
        )
        ORDER BY s.id ASC
        """)
    List<Skill> findAvailabeSkillsForUser(
        @Param("userId") Long userId,
        @Param("excludedStatus") SkillStatus excludedStatus,
        Pageable pageable
    );
}
