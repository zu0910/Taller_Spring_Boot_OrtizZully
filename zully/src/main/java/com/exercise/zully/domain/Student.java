package com.exercise.zully.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "students")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "age")
    private Integer age;
    
    @Column(name = "cellphone", length = 50)
    private String cellphone;
    
    @Column(name = "email", length = 50)
    private String email;
    
    @Column(name = "firstname", length = 50)
    private String firstname;
    
    @Column(name = "lastname", length = 50)
    private String lastname;
    
    @ManyToOne
    @JoinColumn(name = "city_id", insertable = false, updatable = false)
    private City city;
    
    @ManyToOne
    @JoinColumn(name = "school_id", insertable = false, updatable = false)
    private School school;
    
    @OneToMany(mappedBy = "student")
    private List<Exam> exams;

    public Student(Integer id, Integer age, String cellphone, String email, String firstname, String lastname,
            City city, School school, List<Exam> exams) {
        this.id = id;
        this.age = age;
        this.cellphone = cellphone;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
        this.school = school;
        this.exams = exams;
    }

    
    
}