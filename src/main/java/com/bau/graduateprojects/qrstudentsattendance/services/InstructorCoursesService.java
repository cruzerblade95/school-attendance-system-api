package com.bau.graduateprojects.qrstudentsattendance.services;

import com.bau.graduateprojects.qrstudentsattendance.models.InstructorCourses;

import java.util.List;

public interface InstructorCoursesService {

    List<InstructorCourses> getAll();

    List<InstructorCourses> getAllCoursesByInstructorId(Long id);

    List<InstructorCourses> getAllInstructorsByCourseId(Long id);
}
