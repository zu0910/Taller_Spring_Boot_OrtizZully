package com.exercise.zully.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "role")
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "name", length = 255)
    private String name;
    
    @OneToMany(mappedBy = "role")
    private List<GrantedPermission> grantedPermissions;
    
    @OneToMany(mappedBy = "role")
    private List<User> users;

    public Role(Integer id, String name, List<GrantedPermission> grantedPermissions, List<User> users) {
        this.id = id;
        this.name = name;
        this.grantedPermissions = grantedPermissions;
        this.users = users;
    }
    
    
}
