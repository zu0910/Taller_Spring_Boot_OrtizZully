package com.exercise.zully.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "test_config")
public class TestConfig {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "end_date")
    private LocalDate endDate;
    
    @Column(name = "is_active")
    private Boolean isActive;
    
    @Column(name = "score")
    private Integer score;
    
    @Column(name = "start_date")
    private LocalDate startDate;
    
    @Column(name = "description", length = 90)
    private String description;
    
    @Column(name = "test_summary")
    private String testSummary;
    
    @OneToMany(mappedBy = "testConfig")
    private List<Exam> exams;
    
    @OneToMany(mappedBy = "testConfig")
    private List<TestQuestion> testQuestions;

    public TestConfig(Integer id, LocalDate endDate, Boolean isActive, Integer score, LocalDate startDate,
            String description, String testSummary, List<Exam> exams, List<TestQuestion> testQuestions) {
        this.id = id;
        this.endDate = endDate;
        this.isActive = isActive;
        this.score = score;
        this.startDate = startDate;
        this.description = description;
        this.testSummary = testSummary;
        this.exams = exams;
        this.testQuestions = testQuestions;
    }
    
    
}
