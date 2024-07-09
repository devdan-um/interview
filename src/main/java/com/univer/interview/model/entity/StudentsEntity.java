package com.univer.interview.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "STUDENTS")
public class StudentsEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id_student")
    private int idStudent;

    @Column(name = "NAME")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "ID_COURSE", nullable = false)
    private CourseEntity course;
}
