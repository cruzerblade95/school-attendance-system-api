package com.bau.graduateprojects.qrstudentsattendance.servicies.integration;

import com.bau.graduateprojects.qrstudentsattendance.entities.CourseEntity;
import com.bau.graduateprojects.qrstudentsattendance.entities.StudentEntity;
import com.bau.graduateprojects.qrstudentsattendance.entities.TeacherEntity;

public interface IntegrationService {
    StudentEntity addCourseToStudent(Long sId, Long cId);

    void removeCourseFromStudent(Long sId, Long cId);

    TeacherEntity addCourseToTeacher(Long tId, Long cId);

    void removeCourseToTeacher(Long tId, Long cId);

    CourseEntity addLectureToCourse(Long lId, Long cId);

    void removeLectureFromCourse(Long lId, Long cId);
}
