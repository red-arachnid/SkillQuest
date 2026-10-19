package com.skillquest.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillquest.backend.model.UserSkill;

public interface UserSkillRepository extends JpaRepository<UserSkill, Long>{
    boolean existsByUserIdAndSkillId(Long userId, Long skillId);
}
