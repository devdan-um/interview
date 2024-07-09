package com.univer.interview.controller;

import com.univer.interview.model.request.StudentRequest;
import com.univer.interview.model.response.StudentResponse;
import com.univer.interview.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationFormController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/registration")
    public String registryForm(Model model){
        model.addAttribute("list", this.courseService.searchCourse());
        return "registration.html";
    }

    @PostMapping("/registration")
    public String dataSubmit(@ModelAttribute StudentRequest request, Model model){
        StudentResponse response = this.courseService.enrollStudent(request);
        model.addAttribute("response", response);
        return "successfull";
    }

}
