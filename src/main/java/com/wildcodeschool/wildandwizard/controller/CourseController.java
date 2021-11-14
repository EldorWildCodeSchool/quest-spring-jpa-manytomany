package com.wildcodeschool.wildandwizard.controller;

import com.wildcodeschool.wildandwizard.entity.Course;
import com.wildcodeschool.wildandwizard.entity.Wizard;
import com.wildcodeschool.wildandwizard.repository.CourseRepository;
import com.wildcodeschool.wildandwizard.repository.WizardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private WizardRepository wizardRepository;

    @GetMapping("/course")
    public String getCourses(Model out) {

        out.addAttribute("courses", courseRepository.findAll());
        return "courses";
    }

    @GetMapping("/students")
        public String getStudents(Model out, @RequestParam(required = true, defaultValue = "0") Long idCourse){

        Optional<Course> optionalCourse = courseRepository.findById(idCourse);
        Course course = new Course();
        List<Wizard> wizards = new ArrayList<>();
        if (optionalCourse.isPresent()) {
            course = optionalCourse.get();
            wizards= course.getWizards();
        }
        out.addAttribute("course", course);
        out.addAttribute("wizards", wizards);

        return "students";
        }
}

