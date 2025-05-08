package com.exercise.zully.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "countries")
public class Country {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "created_at", columnDefinition = "TIMESTAMP(6)", updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP(6)", updatable = false)
    private LocalDateTime updatedAt;
    
    @Column(name = "country_name", length = 50)
    private String countryName;
    
    @OneToMany(mappedBy = "country")
    private List<State> states;

    public Country(Integer id, LocalDateTime createdAt, LocalDateTime updatedAt, String countryName,
            List<State> states) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.countryName = countryName;
        this.states = states;
    }
    
    
}
