package com.exercise.zully.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "schools")
public class School {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "created_at", columnDefinition = "TIMESTAMP(6)", updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP(6)", updatable = false)
    private LocalDateTime updatedAt;
    
    @Column(name = "description_school", length = 50)
    private String descriptionSchool;
    
    @Column(name = "headmaster_school", length = 50)
    private String headmasterSchool;
    
    @Column(name = "telephone_school", length = 80)
    private String telephoneSchool;
    
    @Column(name = "email_school", length = 80)
    private String emailSchool;
    
    @ManyToOne
    @JoinColumn(name = "city_id", insertable = false, updatable = false)
    private City city;
    
    @OneToMany(mappedBy = "school")
    private List<Student> students;

    public School(Integer id, LocalDateTime createdAt, LocalDateTime updatedAt, String descriptionSchool,
            String headmasterSchool, String telephoneSchool, String emailSchool, City city, List<Student> students) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.descriptionSchool = descriptionSchool;
        this.headmasterSchool = headmasterSchool;
        this.telephoneSchool = telephoneSchool;
        this.emailSchool = emailSchool;
        this.city = city;
        this.students = students;
    }

    
    
    
}