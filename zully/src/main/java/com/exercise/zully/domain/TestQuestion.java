package com.exercise.zully.domain;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@Table(name = "test_questions")
public class TestQuestion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "question_id", insertable = false, updatable = false)
    private Question question;
    
    @ManyToOne
    @JoinColumn(name = "testconfig_id", insertable = false, updatable = false)
    private TestConfig testConfig;

    public TestQuestion(Integer id, Question question, TestConfig testConfig) {
        this.id = id;
        this.question = question;
        this.testConfig = testConfig;
    }

    
}
