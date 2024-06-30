package com.petproject.student.management.project.controller;

import com.petproject.student.management.project.model.Student;
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
    private List<Student> students = new ArrayList<>();
    // Adding dummy students
//    public StudentController(){
//        // Adding dummy students
//        students.add(new Student("John", "Doe", "john@example.com"));
//        students.add(new Student("Mary", "Moe", "mary@example.com"));
//        students.add(new Student("July", "Dooley", "july@example.com"));
//    }

    @GetMapping
    public String getAllStudents(Model model){
        model.addAttribute("students", students);
        return "index";
    }
    @GetMapping("/create")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "create"; // Ensure this matches the path to your template
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student){
        System.out.println("Created");
        students.add(student);
        return "redirect:/student";
    }
}
