package com.univer.interview.model.response;

import com.univer.interview.model.entity.ClassEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class StudentResponse {

    private String name;
    private String course;
    private List<ClassEntity> listClass;

    @Override
    public String toString() {
        String output ="Alumno : " + name + "\nCurso: " +  course + "\nMaterias:\n";

        for (ClassEntity classEntity : listClass) {
            output = output.concat(classEntity.toString());
        }

        return output;
    }
}
