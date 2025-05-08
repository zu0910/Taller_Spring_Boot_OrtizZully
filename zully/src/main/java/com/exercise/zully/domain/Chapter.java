package com.exercise.zully.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "chapters")
public class Chapter {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "numberchapter")
    private Integer numberchapter;
    
    @Column(name = "created_at", columnDefinition = "TIMESTAMP(6)", updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP(6)")
    private LocalDateTime updatedAt;
    
    @Column(name = "description", length = 80)
    private String description;
    
    @Column(name = "chapter_summary")
    private String chapterSummary;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skill_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private Skill skill;
    
    @OneToMany(mappedBy = "chapter", cascade = CascadeType.REMOVE)
    private List<SubChapter> subChapters;

    

    public Chapter(Integer id, Integer numberchapter, LocalDateTime createdAt, LocalDateTime updatedAt,
            String description, String chapterSummary, Skill skill, List<SubChapter> subChapters) {
        this.id = id;
        this.numberchapter = numberchapter;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.chapterSummary = chapterSummary;
        this.skill = skill;
        this.subChapters = subChapters;
    }

    public Chapter() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberchapter() {
        return numberchapter;
    }

    public void setNumberchapter(Integer numberchapter) {
        this.numberchapter = numberchapter;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
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


    public List<SubChapter> getSubChapters() {
        return subChapters;
    }

    public void setSubChapters(List<SubChapter> subChapters) {
        this.subChapters = subChapters;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    

    

    
    
}
