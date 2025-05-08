package com.exercise.zully.aplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exercise.zully.domain.Chapter;
import com.exercise.zully.domain.dto.ChapterRequest;

@Service
public interface ChapterService {

    List<Chapter> findAllChapters();
    Chapter findChapterById(Integer id);
    boolean createChapter(ChapterRequest chapterRequest);
    boolean updateChapter(ChapterRequest chapterRequest);
    boolean deleteChapter(Integer id);
}
