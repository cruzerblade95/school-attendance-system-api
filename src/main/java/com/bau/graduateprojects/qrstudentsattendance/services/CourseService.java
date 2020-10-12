package com.bau.graduateprojects.qrstudentsattendance.services;

import com.bau.graduateprojects.qrstudentsattendance.models.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course);

    List<Course> getAllCourses();

    Course getCourseById(Long id);

    Course updateCourse(Course course, Long id);

    void deleteCourse(Long id);
}
