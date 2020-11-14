package com.bau.graduateprojects.qrstudentsattendance.controllers;

import com.bau.graduateprojects.qrstudentsattendance.entities.CourseEntity;
import com.bau.graduateprojects.qrstudentsattendance.servicies.course.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseEntity> list() {
        return courseService.list();
    }

    @GetMapping("/{id}")
    public CourseEntity getById(@PathVariable Long id) {
        return courseService.getById(id);
    }

    @GetMapping("/count")
    public Long getCount() {
        return courseService.getCount();
    }

    @PostMapping
    public CourseEntity insert(@RequestBody CourseEntity courseEntity) {
        return courseService.insert(courseEntity);
    }

    @PutMapping
    public CourseEntity update(@RequestBody CourseEntity courseEntity) {
        return courseService.update(courseEntity);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable Long id) {
        courseService.removeById(id);
    }
}
