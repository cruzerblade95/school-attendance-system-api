package com.bau.graduateprojects.qrstudentsattendance.controllers;

import com.bau.graduateprojects.qrstudentsattendance.models.Student;
import com.bau.graduateprojects.qrstudentsattendance.services.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody @Valid Student Student) {
        return studentService.createStudent(Student);
    }
}
