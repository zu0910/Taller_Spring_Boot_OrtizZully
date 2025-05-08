package com.exercise.zully.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.zully.domain.SkillRoutePath;



public interface SkillRoutePathRepository extends JpaRepository<SkillRoutePath, Integer> {
    
}
