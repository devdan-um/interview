package com.univer.interview.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "COURSE")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private int idCourse;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "course")
    private Set<ClassEntity> classes;

}
