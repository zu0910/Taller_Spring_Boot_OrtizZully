package com.exercise.zully.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "module")
public class Module {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "base_path", length = 255)
    private String basePath;
    
    @Column(name = "name", length = 255)
    private String name;
    
    @OneToMany(mappedBy = "module")
    private List<Operation> operations;

    public Module(Integer id, String basePath, String name, List<Operation> operations) {
        this.id = id;
        this.basePath = basePath;
        this.name = name;
        this.operations = operations;
    }
    
    
}