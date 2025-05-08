package com.exercise.zully.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "answers")
public class Answer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "is_correct")
    private Boolean isCorrect;
    
    @Column(name = "created_at", columnDefinition = "TIMESTAMP(6)", updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP(6)", updatable = false)
    private LocalDateTime updatedAt;
    
    @Column(name = "description", length = 80)
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "question_id", updatable = false)
    private Question question;

    public Answer(Integer id, Boolean isCorrect, LocalDateTime createdAt, LocalDateTime updatedAt, String description,
            Question question) {
        this.id = id;
        this.isCorrect = isCorrect;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.question = question;
    }

    
}