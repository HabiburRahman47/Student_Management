package com.petproject.student.management.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    @GetMapping
    public String test(){
        return "home";
    }
}
