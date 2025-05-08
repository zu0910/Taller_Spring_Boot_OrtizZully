package com.exercise.zully.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "states")
public class State {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "created_at", columnDefinition = "TIMESTAMP(6)", updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP(6)", updatable = false)
    private LocalDateTime updatedAt;
    
    @Column(name = "abbreviation", length = 50)
    private String abbreviation;
    
    @Column(name = "name_state", length = 50)
    private String nameState;
    
    @ManyToOne
    @JoinColumn(name = "country_id", insertable = false, updatable = false)
    private Country country;
    
    @OneToMany(mappedBy = "state")
    private List<City> cities;

    public State(Integer id, LocalDateTime createdAt, LocalDateTime updatedAt, String abbreviation, String nameState,
            Country country, List<City> cities) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.abbreviation = abbreviation;
        this.nameState = nameState;
        this.country = country;
        this.cities = cities;
    }


    
}