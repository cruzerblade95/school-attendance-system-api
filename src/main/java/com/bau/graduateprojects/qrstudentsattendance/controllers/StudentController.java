package com.bau.graduateprojects.qrstudentsattendance.controllers;

import com.bau.graduateprojects.qrstudentsattendance.models.Student;
import com.bau.graduateprojects.qrstudentsattendance.services.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping
    public List<Student> listAllStudents() {
        return studentService.listAllStudents();
    }

    @GetMapping("/{username}")
    public Student getStudentByUsername(@PathVariable String username) {
        return studentService.getStudentByUsername(username);
    }

    @PutMapping("/{username}")
    public Student updateStudent(@RequestBody @Valid Student student, @PathVariable String username) {
        return studentService.updateStudent(username, student);
    }

    @DeleteMapping("/{username}")
    public void deleteStudent(@PathVariable String username) {
        studentService.deleteStudent(username);
    }
}
