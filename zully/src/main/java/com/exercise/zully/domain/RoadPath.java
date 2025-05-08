package com.exercise.zully.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "road_paths")
public class RoadPath {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "isActive")
    private Boolean isActive;
    
    @Column(name = "created_at", columnDefinition = "TIMESTAMP(6)", updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP(6)", updatable = false)
    private LocalDateTime updatedAt;
    
    @Column(name = "image_path", length = 80)
    private String imagePath;
    
    @Column(name = "path_name", length = 80)
    private String pathName;
    
    @Column(name = "description")
    private String description;
    
    @OneToMany(mappedBy = "roadPath")
    private List<SkillRoutePath> skillRoutePaths;

    public RoadPath(Integer id, Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt, String imagePath,
            String pathName, String description, List<SkillRoutePath> skillRoutePaths) {
        this.id = id;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.imagePath = imagePath;
        this.pathName = pathName;
        this.description = description;
        this.skillRoutePaths = skillRoutePaths;
    }
    
    
}