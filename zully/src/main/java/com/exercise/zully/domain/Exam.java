package com.exercise.zully.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "exams")
public class Exam {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "date_presentation")
    private LocalDate datePresentation;
    
    @Column(name = "student_id")
    private Integer studentId;
    
    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;
    
    @ManyToOne
    @JoinColumn(name = "testconf_id", insertable = false, updatable = false)
    private TestConfig testConfig;

    public Exam(Integer id, LocalDate datePresentation, Integer studentId, Student student, TestConfig testConfig) {
        this.id = id;
        this.datePresentation = datePresentation;
        this.studentId = studentId;
        this.student = student;
        this.testConfig = testConfig;
    }
    
    
}
