package com.univer.interview.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;

import java.util.logging.LogManager;

@Getter
@Setter
@Log4j2
public class StudentRequest {
    private String name;
    private String email;
    private String age;
    private String course;
    private String courseName;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setEmail(String email) {
        log.info("Se construye el email");
        this.email = email.concat("@univermilenium.com");;
    }
}
