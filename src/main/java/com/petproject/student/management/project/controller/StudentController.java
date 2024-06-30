package com.petproject.student.management.project.controller;

import com.petproject.student.management.project.model.Student;
import com.petproject.student.management.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public String getAllStudents(Model model){
        model.addAttribute("students", studentService.getAllStudent());
        return "index";
    }

    @GetMapping("/create")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "create"; // Ensure this matches the path to your template
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student){
        studentService.createStudent(student);
        return "redirect:/student";
    }

    @GetMapping("/edit")
    public String editForm(){
        return "edit";
    }
}
