package com.exercise.zully.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.zully.domain.SkillRoutePath;
import java.util.List;
import java.util.Optional;


public interface SkillRoutePathRepository extends JpaRepository<SkillRoutePath, Integer> {
    Optional<SkillRoutePath> findById(Integer id);
}
