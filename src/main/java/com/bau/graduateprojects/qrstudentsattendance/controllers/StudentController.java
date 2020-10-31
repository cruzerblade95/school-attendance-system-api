package com.bau.graduateprojects.qrstudentsattendance.controllers;

import com.bau.graduateprojects.qrstudentsattendance.entities.StudentEntity;
import com.bau.graduateprojects.qrstudentsattendance.repositories.student.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<StudentEntity> list() {
        return studentRepository.list();
    }

    @GetMapping("/username/{username}")
    public StudentEntity getStudentByUsername(@PathVariable String username) {
        return studentRepository.getByUsername(username);
    }

    @GetMapping("/id/{id}")
    public StudentEntity getStudentById(@PathVariable Long id) {
        return studentRepository.getById(id);
    }

    @PostMapping
    public StudentEntity insert(@RequestBody StudentEntity studentEntity) {
        return studentRepository.add(studentEntity);
    }

    @PutMapping
    public StudentEntity update(@RequestBody StudentEntity studentEntity) {
        return studentRepository.update(studentEntity);
    }

    @DeleteMapping("/{username}")
    public void delete(@PathVariable String username) {
        studentRepository.remove(username);
    }
}
