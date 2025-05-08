package com.exercise.zully.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "type_options")
public class TypeOption {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "description", length = 80)
    private String description;
    
    @Column(name = "tag_option", length = 80)
    private String tagOption;
    
    @OneToMany(mappedBy = "typeOption")
    private List<Question> questions;

    public TypeOption(Integer id, String description, String tagOption, List<Question> questions) {
        this.id = id;
        this.description = description;
        this.tagOption = tagOption;
        this.questions = questions;
    }
    
    
}