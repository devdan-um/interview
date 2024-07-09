package com.univer.interview.service;

import com.univer.interview.model.entity.ClassEntity;
import com.univer.interview.model.entity.CourseEntity;
import com.univer.interview.model.entity.StudentsEntity;
import com.univer.interview.model.request.StudentRequest;
import com.univer.interview.model.response.StudentResponse;
import com.univer.interview.repository.IClassRepository;
import com.univer.interview.repository.ICourseRepository;
import com.univer.interview.repository.IStudentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class CourseService {

    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private IClassRepository classRepository;

    @Autowired
    private IStudentRepository studentRepository;

    public List<CourseEntity> searchCourse(){
        return courseRepository.findAll();
    }

    public List<ClassEntity> searchClass(String id){
        Optional<List<ClassEntity>> op = classRepository.findByCourse(id);
        if (op.isPresent() && !op.get().stream().toList().isEmpty()){
            return op.get().stream().toList();
        } else {
            return Arrays.asList();
        }
    }

    public StudentResponse enrollStudent(StudentRequest request) {
        StudentsEntity se = new StudentsEntity();
        se.setEmail(request.getEmail());
        se.setName(request.getName());

        try {
            se.setAge(Integer.parseInt(request.getAge()));
        }catch (NumberFormatException e){
            log.error("El elemento recuperado para el atributo edad es incorrecto : {}", e);
            se.setAge(null);
        }

        CourseEntity course = null;

        if (this.courseRepository.findById(Integer.parseInt(request.getCourse())).isPresent()){
            course = this.courseRepository.findById(Integer.parseInt(request.getCourse())).get();
        }
        se.setCourse(course);

        this.studentRepository.save(se);

        StudentResponse response = new StudentResponse(request.getName(), course.getName(), searchClass(request.getCourse()));

        try {
            Path path = Paths.get(response.getName().concat("_file.txt"));
            byte[] strToBytes = response.toString().getBytes();
            Files.write(path, strToBytes);
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return response;
    }

    public List<StudentsEntity> studentsEnrolled(){
        return this.studentRepository.findAll();
    }

}
