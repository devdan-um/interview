package com.univer.interview.controller;

import com.univer.interview.model.entity.StudentsEntity;
import com.univer.interview.model.response.StudentResponse;
import com.univer.interview.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/univer")
public class RegistrationController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/students")
    public ResponseEntity<List<StudentsEntity>> studentsEnrolled(){
        return ResponseEntity.ok(this.courseService.studentsEnrolled());
    }

}
