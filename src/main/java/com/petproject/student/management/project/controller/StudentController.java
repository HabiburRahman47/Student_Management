package com.petproject.student.management.project.controller;

import com.petproject.student.management.project.model.Student;
import com.petproject.student.management.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model){
        Optional<Student> optionalStudent = studentService.getStudent(id);
        System.out.println("Student:"+optionalStudent);
        if (optionalStudent.isPresent()){
            model.addAttribute("student",optionalStudent.get());
            return "edit";
        }else {
            return "redirect:/student";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute Student student){
        studentService.updateStudent(id, student);
        return "redirect:/student";
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        System.out.println("Id: "+id);
        studentService.deleteStudent(id);
        return "redirect:/student";
    }
}
