package com.bau.graduateprojects.qrstudentsattendance.controllers;

import com.bau.graduateprojects.qrstudentsattendance.entities.StudentEntity;
import com.bau.graduateprojects.qrstudentsattendance.entities.TeacherEntity;
import com.bau.graduateprojects.qrstudentsattendance.servicies.integration.IntegrationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/integration")
public class IntegrationController {
    private final IntegrationService integrationService;

    public IntegrationController(IntegrationService integrationService) {
        this.integrationService = integrationService;
    }

    @PutMapping("/course-student/{sId}/{cId}")
    public StudentEntity addCourseToStudent(@PathVariable Long sId, @PathVariable Long cId) {
        return integrationService.addCourseToStudent(sId, cId);
    }

    @DeleteMapping("/course-student/{sId}/{cId}")
    public void removeCourseFromStudent(@PathVariable Long sId, @PathVariable Long cId) {
        integrationService.removeCourseFromStudent(sId, cId);
    }

    @PutMapping("/course-teacher/{tId}/{cId}")
    public TeacherEntity addCourseToTeacher(@PathVariable Long tId, @PathVariable Long cId) {
        return integrationService.addCourseToTeacher(tId, cId);
    }

    @DeleteMapping("/course-teacher/{tId}/{cId}")
    public void removeCourseToTeacher(@PathVariable Long tId, @PathVariable Long cId) {
        integrationService.removeCourseToTeacher(tId, cId);
    }

}
