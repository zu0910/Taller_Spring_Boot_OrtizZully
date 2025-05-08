package com.exercise.zully.infrastructure.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.exercise.zully.aplication.service.ChapterService;
import com.exercise.zully.domain.Chapter;
import com.exercise.zully.domain.Skill;
import com.exercise.zully.domain.SkillRoutePath;
import com.exercise.zully.domain.dto.ChapterRequest;

@Service
public class ChapterServiceImpl implements ChapterService {

    private final ChapterRespository chapterResponsitory;
    private final SkillRepository skillRepository;

    public ChapterServiceImpl(ChapterRespository chapterResponsitory,SkillRepository skillRepository) {
        this.chapterResponsitory = chapterResponsitory;
        this.skillRepository = skillRepository;
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
        Optional<Skill> skill = skillRepository.findById(chapterRequest.getSkill());

        if (!skill.isPresent()){
            return false;
        }

        Optional<Skill> skills = skillRepository.findById(chapterRequest.getSkill());
        if(!skill.isPresent()){
            return false;
        }

        Chapter chapter = new Chapter();
        chapter.setNumberchapter(chapterRequest.getNumberchapter());
        chapter.setDescription(chapterRequest.getDescription());
        chapter.setChapterSummary(chapterRequest.getChapterSummary());
        chapter.setSkill(skills.get());
        chapter.setCreatedAt(LocalDateTime.now());
        chapter.setUpdatedAt(LocalDateTime.now());
        
        chapterResponsitory.save(chapter);
        return true;
    }


    @Override
    public boolean updateChapter( ChapterRequest chapterRequest){
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
        if (chapterRequest.getSkill() != null) {
            Optional<Skill> skill = skillRepository.findById(chapterRequest.getSkill());
            if (!skill.isPresent()) {
                return false;
            }
            chapter.setSkill(skill.get());
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
