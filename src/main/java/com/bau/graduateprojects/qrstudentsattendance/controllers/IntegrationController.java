package com.bau.graduateprojects.qrstudentsattendance.controllers;

import com.bau.graduateprojects.qrstudentsattendance.entities.*;
import com.bau.graduateprojects.qrstudentsattendance.servicies.integration.IntegrationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/integration")
public class IntegrationController {
    private final IntegrationService integrationService;

    public IntegrationController(IntegrationService integrationService) {
        this.integrationService = integrationService;
    }

    @GetMapping("/course-student/courses/{sId}")
    public List<CourseEntity> getAllCoursesByStudentId(@PathVariable Long sId) {
        return integrationService.getAllCoursesByStudentId(sId);
    }

    @GetMapping("/course-student/students/{cId}")
    public List<StudentEntity> getAllStudentsByCourseId(@PathVariable Long cId) {
        return integrationService.getAllStudentsByCourseId(cId);
    }

    @PostMapping("/course-student")
    public StudentCourseEntity addCourseToStudent(@RequestBody StudentCourseEntity entity) {
        return integrationService.addCourseToStudent(entity);
    }

    @DeleteMapping("/course-student/{sId}/{cId}")
    public void removeCourseFromStudent(@PathVariable Long sId, @PathVariable Long cId) {
        integrationService.removeCourseFromStudent(sId, cId);
    }

    @GetMapping("/course-teacher/courses/{tId}")
    public List<CourseEntity> getAllCoursesByTeacherId(@PathVariable Long tId) {
        return integrationService.getAllCoursesByTeacherId(tId);
    }

    @PostMapping("/course-teacher")
    public TeacherCourseEntity addCourseToTeacher(@RequestBody TeacherCourseEntity entity) {
        return integrationService.addCourseToTeacher(entity);
    }

    @DeleteMapping("/course-teacher/{tId}/{cId}")
    public void removeCourseFromTeacher(@PathVariable Long tId, @PathVariable Long cId) {
        integrationService.removeCourseFromTeacher(tId, cId);
    }

    @GetMapping("/lecture-course/lectures/{cId}")
    public List<LectureEntity> getAllLecturesByCourseId(@PathVariable Long cId) {
        return integrationService.getAllLecturesByCourseId(cId);
    }

    @PostMapping("/lecture-course")
    public LectureCourseEntity addLectureToCourse(@RequestBody LectureCourseEntity entity) {
        return integrationService.addLectureToCourse(entity);
    }

    @DeleteMapping("/lecture-course/{lId}/{cId}")
    public void removeLectureFromCourse(@PathVariable Long lId, @PathVariable Long cId) {
        integrationService.removeLectureFromCourse(lId, cId);
    }

    @GetMapping("/lecture-attendance/lectures/{lId}")
    public List<AttendanceEntity> getAllAttendanceByLectureId(@PathVariable Long lId) {
        return integrationService.getAllAttendanceByLectureId(lId);
    }

    @PostMapping("/lecture-attendance")
    public LectureAttendanceEntity addAttendanceToLecture(@RequestBody LectureAttendanceEntity entity) {
        return integrationService.addAttendanceToLecture(entity);
    }

    @PutMapping("/lecture-attendance/update/{attId}")
    public AttendanceEntity updateStatusAttendanceId(@PathVariable Long attId) {
        return integrationService.updateStatusAttendanceId(attId);
    }
}
