package com.bau.graduateprojects.qrstudentsattendance.controllers;

import com.bau.graduateprojects.qrstudentsattendance.models.InstructorCourses;
import com.bau.graduateprojects.qrstudentsattendance.services.InstructorCoursesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instructor-courses")
public class InstructorCoursesController {

    private final InstructorCoursesService instructorCoursesService;

    public InstructorCoursesController(InstructorCoursesService instructorCoursesService) {
        this.instructorCoursesService = instructorCoursesService;
    }

    @GetMapping
    public List<InstructorCourses> getAll() {
        return instructorCoursesService.getAll();
    }

    @GetMapping("/instructor/{id}")
    public List<InstructorCourses> getAllCoursesByInstructorId(@PathVariable Long id) {
        return instructorCoursesService.getAllCoursesByInstructorId(id);
    }

    @GetMapping("/course/{id}")
    public List<InstructorCourses> getAllInstructorsByCourseId(@PathVariable Long id) {
        return instructorCoursesService.getAllInstructorsByCourseId(id);
    }


}
