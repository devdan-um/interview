package com.univer.interview.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "CLASS")
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_class")
    private long idClass;
    @Column(name = "NAME")
    private String name;
    @Column(name = "HOURS_PER_WEEK")
    private Integer hoursPerWeek;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_COURSE", nullable = false)
    private CourseEntity course;

    @Override
    public String toString() {
        return name + "\t\t" +  hoursPerWeek + " horas semanales\n";
    }

}
