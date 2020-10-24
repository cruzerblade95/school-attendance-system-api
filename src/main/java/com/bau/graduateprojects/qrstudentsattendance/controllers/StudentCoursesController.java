package com.bau.graduateprojects.qrstudentsattendance.controllers;

import com.bau.graduateprojects.qrstudentsattendance.models.StudentCourses;
import com.bau.graduateprojects.qrstudentsattendance.services.StudentCoursesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student-courses")
public class StudentCoursesController {
    private final StudentCoursesService studentCoursesService;

    public StudentCoursesController(StudentCoursesService studentCoursesService) {
        this.studentCoursesService = studentCoursesService;
    }

    @GetMapping("/student/{id}")
    public List<StudentCourses> getAllCoursesByStudentId(@PathVariable Long id) {
        return studentCoursesService.getAllCoursesByStudentId(id);
    }

    @GetMapping("/course/{id}/")
    public List<StudentCourses> getAllStudentsByCourseId(@PathVariable Long id) {
        return studentCoursesService.getAllStudentsByCourseId(id);
    }

    @PutMapping("/student-absence/{studentId}/{courseId}")
    public StudentCourses addNewAbsence(@PathVariable Long studentId, @PathVariable Long courseId) {
        return studentCoursesService.addNewAbsence(studentId, courseId);
    }

    @PostMapping
    public StudentCourses addNewStudentCourses(@RequestBody StudentCourses studentCourses) {
        return studentCoursesService.addNewStudentCourses(studentCourses);
    }

    @DeleteMapping("/{courseId}/{studentId}")
    public void deleteStudentCourses(@PathVariable Long courseId, @PathVariable Long studentId) {
        studentCoursesService.deleteStudentCourses(courseId, studentId);
    }


}
