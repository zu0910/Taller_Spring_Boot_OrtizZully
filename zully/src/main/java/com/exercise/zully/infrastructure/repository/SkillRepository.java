package com.exercise.zully.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.zully.domain.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer>{
    Optional<Skill> findById(Integer id);
}
