package com.exercise.zully.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "subchapters")
public class SubChapter {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description", length = 80)
    private String description;
    
    @Column(name = "summary")
    private String summary;
    
    @ManyToOne
    @JoinColumn(name = "chapter_id", insertable = false, updatable = false)
    private Chapter chapter;
    
    @OneToMany(mappedBy = "subChapter")
    private List<MediaSubChapter> mediaSubChapters;

    public SubChapter(Integer id, String description, String summary, Chapter chapter,
            List<MediaSubChapter> mediaSubChapters) {
        this.id = id;
        this.description = description;
        this.summary = summary;
        this.chapter = chapter;
        this.mediaSubChapters = mediaSubChapters;
    }

    
    
    
}
