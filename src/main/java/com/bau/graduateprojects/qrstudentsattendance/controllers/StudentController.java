package com.bau.graduateprojects.qrstudentsattendance.controllers;

import com.bau.graduateprojects.qrstudentsattendance.entities.StudentEntity;
import com.bau.graduateprojects.qrstudentsattendance.servicies.student.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public List<StudentEntity> list() {
        return studentService.list();
    }

    @GetMapping("/id/{id}")
    public StudentEntity getById(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @GetMapping("/username/{username}")
    public StudentEntity getByUsername(@PathVariable String username) {
        return studentService.getByUsername(username);
    }

    @PostMapping
    public StudentEntity insert(@RequestBody StudentEntity studentEntity) {
        return studentService.insert(studentEntity);
    }

    @PutMapping()
    public StudentEntity update(@RequestBody StudentEntity studentEntity) {
        return studentService.update(studentEntity);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable Long id) {
        studentService.removeById(id);
    }

}
