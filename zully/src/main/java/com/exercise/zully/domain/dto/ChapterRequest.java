package com.exercise.zully.domain.dto;

public class ChapterRequest {

    private Integer id;
    private Integer numberchapter;
    private String description;
    private String chapterSummary;
    private Integer skill;

    

    public ChapterRequest() {
    }

    
    public ChapterRequest(Integer id, Integer numberchapter, String description, String chapterSummary,
            Integer skill) {
        this.id = id;
        this.numberchapter = numberchapter;
        this.description = description;
        this.chapterSummary = chapterSummary;
        this.skill = skill;
    }

    public ChapterRequest(Integer numberchapter, String description, String chapterSummary, Integer skill) {
        this.numberchapter = numberchapter;
        this.description = description;
        this.chapterSummary = chapterSummary;
        this.skill = skill;
    }


    public Integer getNumberchapter() {
        return numberchapter;
    }
    public void setNumberchapter(Integer numberchapter) {
        this.numberchapter = numberchapter;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getChapterSummary() {
        return chapterSummary;
    }
    public void setChapterSummary(String chapterSummary) {
        this.chapterSummary = chapterSummary;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getSkill() {
        return skill;
    }


    public void setSkill(Integer skill) {
        this.skill = skill;
    }

    

}
