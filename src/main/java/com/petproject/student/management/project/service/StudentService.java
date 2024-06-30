package com.petproject.student.management.project.service;

import com.petproject.student.management.project.model.Student;
import com.petproject.student.management.project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public void createStudent(Student student){
        studentRepository.save(student);
    }

    public Optional<Student> getStudent(Long id){
        return studentRepository.findById(id);
    }

    public void updateStudent(Long id, Student updatedStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()){
            Student existingStudent = optionalStudent.get();
            existingStudent.setFirstname(updatedStudent.getFirstname());
            existingStudent.setLastname(updatedStudent.getLastname());
            existingStudent.setEmail(updatedStudent.getEmail());
            studentRepository.save(existingStudent);
        }else {
            throw new RuntimeException("Student not found with id:"+id);
        }
    }
}


