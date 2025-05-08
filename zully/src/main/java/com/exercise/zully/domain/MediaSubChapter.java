package com.exercise.zully.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "media_sub_chapters")
public class MediaSubChapter {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "created_at", columnDefinition = "TIMESTAMP(6)", updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP(6)", updatable = false)
    private LocalDateTime updatedAt;
    
    @Column(name = "description", length = 80)
    private String description;
    
    @Column(name = "summary")
    private String summary;
    
    @ManyToOne
    @JoinColumn(name = "media_id", insertable = false, updatable = false)
    private Media media;
    
    @ManyToOne
    @JoinColumn(name = "subchapter_id", insertable = false, updatable = false)
    private SubChapter subChapter;

    public MediaSubChapter(Integer id, LocalDateTime createdAt, LocalDateTime updatedAt, String description,
            String summary, Media media, SubChapter subChapter) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.summary = summary;
        this.media = media;
        this.subChapter = subChapter;
    }
    
    

}