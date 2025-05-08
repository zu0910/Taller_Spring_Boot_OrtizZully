package com.exercise.zully.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "media_types")
public class Media {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "description", length = 50)
    private String description;
    
    @OneToMany(mappedBy = "media")
    private List<MediaSubChapter> mediaSubChapters;

    public Media(Integer id, String description, List<MediaSubChapter> mediaSubChapters) {
        this.id = id;
        this.description = description;
        this.mediaSubChapters = mediaSubChapters;
    }
    
    
}
