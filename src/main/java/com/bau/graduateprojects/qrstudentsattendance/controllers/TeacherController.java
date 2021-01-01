package com.bau.graduateprojects.qrstudentsattendance.controllers;

import com.bau.graduateprojects.qrstudentsattendance.entities.CourseEntity;
import com.bau.graduateprojects.qrstudentsattendance.entities.TeacherEntity;
import com.bau.graduateprojects.qrstudentsattendance.servicies.teacher.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<TeacherEntity> list() {
        return teacherService.list();
    }

    @GetMapping("/id/{id}")
    public TeacherEntity getById(@PathVariable Long id) {
        return teacherService.getById(id);
    }

    @GetMapping("/username/{username}")
    public TeacherEntity getByUsername(@PathVariable String username) {
        return teacherService.getByUsername(username);
    }

    @GetMapping("/username/{username}/courses")
    public List<CourseEntity> getCourses(@PathVariable String username) {
        return teacherService.getCourses(username);
    }

    @GetMapping("/count")
    public Long getCount() {
        return teacherService.getCount();
    }

    @PutMapping
    public TeacherEntity update(@RequestBody TeacherEntity teacherEntity) {
        return teacherService.update(teacherEntity);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable Long id) {
        teacherService.removeById(id);
    }

    @PostMapping
    public TeacherEntity insert(@RequestBody TeacherEntity teacherEntity) {
        return teacherService.insert(teacherEntity);
    }

    @PostMapping("/login/{username}/{password}")
    public TeacherEntity login(@PathVariable String username, @PathVariable String password) {
        return teacherService.login(username, password);
    }

}
