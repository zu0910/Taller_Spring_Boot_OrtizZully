package com.exercise.zully.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "skills")
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "created_at", columnDefinition = "TIMESTAMP(6)", updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP(6)", updatable = false)
    private LocalDateTime updatedAt;
    
    @Column(name = "kcount", length = 80) 
    private String kcount;
    
    @Column(name = "skill_name", length = 80)
    private String skillName;
    
    @Column(name = "skill_description")
    private String skillDescription;
    
    @OneToMany(mappedBy = "skill")
    private List<Chapter> chapters;
    
    @OneToMany(mappedBy = "skill")
    private List<SkillRoutePath> skillRoutePaths;

    public Skill(Integer id, LocalDateTime createdAt, LocalDateTime updatedAt, String kcount, String skillName,
            String skillDescription, List<Chapter> chapters, List<SkillRoutePath> skillRoutePaths) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.kcount = kcount;
        this.skillName = skillName;
        this.skillDescription = skillDescription;
        this.chapters = chapters;
        this.skillRoutePaths = skillRoutePaths;
    }
    
    
}