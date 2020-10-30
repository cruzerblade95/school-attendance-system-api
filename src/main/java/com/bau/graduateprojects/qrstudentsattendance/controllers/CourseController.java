//package com.bau.graduateprojects.qrstudentsattendance.controllers;
//
//import com.bau.graduateprojects.qrstudentsattendance.services.CourseService;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/courses")
//public class CourseController {
//    private final CourseService courseService;
//
//    public CourseController(CourseService courseService) {
//        this.courseService = courseService;
//    }
//
//    @PostMapping
//    public Course createCourse(@RequestBody @Valid Course course) {
//        return courseService.createCourse(course);
//    }
//
//    @GetMapping
//    public List<Course> getAllCourses() {
//        return courseService.getAllCourses();
//    }
//
//    @GetMapping("/{id}")
//    public Course getCourseById(@PathVariable Long id) {
//        return courseService.getCourseById(id);
//    }
//
//    @PutMapping("/{id}")
//    public Course updateCourse(@RequestBody Course course, @PathVariable Long id) {
//        return courseService.updateCourse(course, id);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteCourse(@PathVariable Long id) {
//        courseService.deleteCourse(id);
//    }
//}
