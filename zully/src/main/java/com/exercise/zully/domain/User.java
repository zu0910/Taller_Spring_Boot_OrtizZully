package com.exercise.zully.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "name", length = 255)
    private String name;
    
    @Column(name = "password", length = 255)
    private String password;
    
    @Column(name = "username", length = 255)
    private String username;
    
    @ManyToOne
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private Role role;

    public User(Integer id, String name, String password, String username, Role role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.username = username;
        this.role = role;
    }

    
    
    
}
