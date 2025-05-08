package com.exercise.zully.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "operation")
public class Operation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "permit_all")
    private Boolean permitAll;
    
    @Column(name = "path", length = 255)
    private String path;
    
    @Column(name = "name", length = 255)
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "module_id", insertable = false, updatable = false)
    private Module module;
    
    @OneToMany(mappedBy = "operation")
    private List<GrantedPermission> grantedPermissions;

    public Operation(Integer id, Boolean permitAll, String path, String name, Module module,
            List<GrantedPermission> grantedPermissions) {
        this.id = id;
        this.permitAll = permitAll;
        this.path = path;
        this.name = name;
        this.module = module;
        this.grantedPermissions = grantedPermissions;
    }
    
    
}