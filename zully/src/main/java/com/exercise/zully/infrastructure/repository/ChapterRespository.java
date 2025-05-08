package com.exercise.zully.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.zully.domain.Chapter;

public interface ChapterRespository extends JpaRepository<Chapter, Integer> {

    Optional<Chapter> findById(Integer id);
}
