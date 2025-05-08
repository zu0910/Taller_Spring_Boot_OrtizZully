package com.exercise.zully.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "granted_permission")
public class GrantedPermission {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "operation_id")
    private Integer operationId;
    
    @ManyToOne
    @JoinColumn(name = "operation_id", insertable = false, updatable = false)
    private Operation operation;
    
    @ManyToOne
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private Role role;

    public GrantedPermission(Integer id, Integer operationId, Operation operation, Role role) {
        this.id = id;
        this.operationId = operationId;
        this.operation = operation;
        this.role = role;
    }
    
    
}
