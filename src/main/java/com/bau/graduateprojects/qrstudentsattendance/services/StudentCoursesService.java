package com.bau.graduateprojects.qrstudentsattendance.services;

import com.bau.graduateprojects.qrstudentsattendance.models.StudentCourses;

import java.util.List;

public interface StudentCoursesService {
    List<StudentCourses> getAllCoursesByStudentId(Long id);

    List<StudentCourses> getAllStudentsByCourseId(Long id);

    StudentCourses addNewStudentCourses(StudentCourses studentCourses);

    void deleteStudentCourses(Long courseId, Long studentId);

    StudentCourses addNewAbsence(Long studentId, Long courseId);
}
