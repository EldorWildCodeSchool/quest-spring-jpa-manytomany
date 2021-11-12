package com.wildcodeschool.wildandwizard.controller;

import com.wildcodeschool.wildandwizard.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;


    @GetMapping("/course")
    public String getCourses(Model out) {

        out.addAttribute("courses", courseRepository.findAll());
        return "courses";
    }



}
