package com.exercise.zully.infrastructure.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.exercise.zully.aplication.service.ChapterService;
import com.exercise.zully.domain.Chapter;
import com.exercise.zully.domain.SkillRoutePath;
import com.exercise.zully.domain.dto.ChapterRequest;

@Service
public class ChapterServiceImpl implements ChapterService {

    private final ChapterRespository chapterResponsitory;
    private final SkillRoutePathRepository skillRoutePathRepository;

    public ChapterServiceImpl(ChapterRespository chapterResponsitory,
            SkillRoutePathRepository skillRoutePathRepository) {
        this.chapterResponsitory = chapterResponsitory;
        this.skillRoutePathRepository = skillRoutePathRepository;
    }



    @Override
    public List<Chapter> findAllChapters(){
        return chapterResponsitory.findAll();
    }
    
    @Override
    public Chapter findChapterById(Integer id){
        Optional<Chapter> chapter = chapterResponsitory.findById(id);
        if (!chapter.isPresent()){
            return null;
        }
        return chapter.get();
    }

    @Override
    public boolean createChapter(ChapterRequest chapterRequest){
        Optional<SkillRoutePath> skillRoutePath = skillRoutePathRepository.findById(chapterRequest.getSkillRoutedId());

        if (!skillRoutePath.isPresent()){
            return false;
        }

        Chapter chapter = new Chapter();
        chapter.setNumberchapter(chapterRequest.getNumberchapter());
        chapter.setDescription(chapterRequest.getDescription());
        chapter.setChapterSummary(chapterRequest.getChapterSummary());
        chapter.setSkill(skillRoutePath.get());
        chapter.setCreatedAt(LocalDateTime.now());
        chapter.setUpdatedAt(LocalDateTime.now());

        chapterResponsitory.save(chapter);
        return true;
    }

    @Override
    public boolean updateChapter(ChapterRequest chapterRequest){
        Optional<Chapter> chapteOpt = chapterResponsitory.findById(chapterRequest.getId());

        if(!chapteOpt.isPresent()){
            return false;
        }
        Chapter chapter = chapteOpt.get();
        if (chapterRequest.getNumberchapter() != null) {
            chapter.setNumberchapter(chapterRequest.getNumberchapter());
        }
        if (chapterRequest.getDescription() != null) {
            chapter.setDescription(chapterRequest.getDescription());
        }
        if (chapterRequest.getChapterSummary() != null) {
            chapter.setChapterSummary(chapterRequest.getChapterSummary());
        }
        if (chapterRequest.getSkillRoutedId() != null) {
            Optional<SkillRoutePath> skillRoutePath = skillRoutePathRepository.findById(chapterRequest.getSkillRoutedId());
            if (!skillRoutePath.isPresent()) {
                return false;
            }
            chapter.setSkill(skillRoutePath.get());
        }
        chapter.setUpdatedAt(LocalDateTime.now());

        chapterResponsitory.save(chapter);
        return true;
    }

    @Override
    public boolean deleteChapter(Integer id){
        Optional<Chapter> chapter = chapterResponsitory.findById(id);
        if(!chapter.isPresent()){
            return false;
        }
        chapterResponsitory.deleteById(id);
        return true;
    }
}
