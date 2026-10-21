package com.skillquest.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skillquest.backend.model.SkillModule;

public interface SkillModuleRepository extends JpaRepository<SkillModule, Long> {
    
    @Query("""
        SELECT sm FROM SkillModule sm
        WHERE sm.skill.id = :skillId
        ORDER BY position
        """)
    List<SkillModule> getSkillModulesBySkillId(@Param("skillId") Long skillId);
}
