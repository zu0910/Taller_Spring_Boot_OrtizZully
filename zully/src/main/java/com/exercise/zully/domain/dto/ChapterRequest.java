package com.exercise.zully.domain.dto;

public class ChapterRequest {

    private Integer id;
    private Integer numberchapter;
    private String description;
    private String chapterSummary;
    private Integer skillRoutedId;

    

    public ChapterRequest() {
    }

    
    public ChapterRequest(Integer id, Integer numberchapter, String description, String chapterSummary,
            Integer skillRoutedId) {
        this.id = id;
        this.numberchapter = numberchapter;
        this.description = description;
        this.chapterSummary = chapterSummary;
        this.skillRoutedId = skillRoutedId;
    }

    


    public ChapterRequest(Integer numberchapter, String description, String chapterSummary, Integer skillRoutedId) {
        this.numberchapter = numberchapter;
        this.description = description;
        this.chapterSummary = chapterSummary;
        this.skillRoutedId = skillRoutedId;
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
    public Integer getSkillRoutedId() {
        return skillRoutedId;
    }
    public void setSkillRoutedId(Integer skillRoutedId) {
        this.skillRoutedId = skillRoutedId;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    

}
