package com.exercise.zully.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "skill_route_path")
public class SkillRoutePath {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "created_at", columnDefinition = "TIMESTAMP(6)", updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP(6)", updatable = false)
    private LocalDateTime updatedAt;
    
    @ManyToOne
    @JoinColumn(name = "road_path_id", insertable = false, updatable = false)
    private RoadPath roadPath;
    
    @ManyToOne
    @JoinColumn(name = "skill_id", insertable = false, updatable = false)
    private Skill skill;

    public SkillRoutePath(Integer id, LocalDateTime createdAt, LocalDateTime updatedAt, RoadPath roadPath,
            Skill skill) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.roadPath = roadPath;
        this.skill = skill;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public RoadPath getRoadPath() {
        return roadPath;
    }

    public void setRoadPath(RoadPath roadPath) {
        this.roadPath = roadPath;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    
    
}
