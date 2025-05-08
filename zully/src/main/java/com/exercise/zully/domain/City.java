package com.exercise.zully.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "cities")
public class City {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "created_at", columnDefinition = "TIMESTAMP(6)", updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP(6)", updatable = false)
    private LocalDateTime updatedAt;
    
    @Column(name = "name_city", length = 50)
    private String nameCity;
    
    @ManyToOne
    @JoinColumn(name = "state_id", insertable = false, updatable = false)
    private State state;
    
    @OneToMany(mappedBy = "city")
    private List<School> schools;
    
    @OneToMany(mappedBy = "city")
    private List<Student> students;

    public City(Integer id, LocalDateTime createdAt, LocalDateTime updatedAt, String nameCity, State state,
            List<School> schools, List<Student> students) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.nameCity = nameCity;
        this.state = state;
        this.schools = schools;
        this.students = students;
    }
    
    
}