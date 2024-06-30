package com.petproject.student.management.project.repository;

import com.petproject.student.management.project.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
