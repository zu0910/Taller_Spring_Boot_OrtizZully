package com.exercise.zully.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "questions")
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "score")
    private Integer score;

    @Column(name = "description", length = 80)
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "typeoption_id", insertable = false, updatable = false)
    private TypeOption typeOption;
    
    @OneToMany(mappedBy = "question")
    private List<Answer> answers;
    
    @OneToMany(mappedBy = "question")
    private List<TestQuestion> testQuestions;

    public Question(Integer id, Integer score, String description, TypeOption typeOption, List<Answer> answers,
            List<TestQuestion> testQuestions) {
        this.id = id;
        this.score = score;
        this.description = description;
        this.typeOption = typeOption;
        this.answers = answers;
        this.testQuestions = testQuestions;
    }


}