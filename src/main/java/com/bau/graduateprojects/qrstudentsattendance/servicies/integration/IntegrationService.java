package com.bau.graduateprojects.qrstudentsattendance.servicies.integration;

import com.bau.graduateprojects.qrstudentsattendance.entities.*;

import java.util.List;

public interface IntegrationService {
    StudentCourseEntity addCourseToStudent(StudentCourseEntity record);

    void removeCourseFromStudent(Long sId, Long cId);

    TeacherCourseEntity addCourseToTeacher(TeacherCourseEntity entity);

    void removeCourseFromTeacher(Long tId, Long cId);

    void removeLectureFromCourse(Long lId, Long cId);

    List<CourseEntity> getAllCoursesByStudentId(Long sId);

    List<StudentEntity> getAllStudentsByCourseId(Long cId);

    List<CourseEntity> getAllCoursesByTeacherId(Long tId);

    LectureCourseEntity addLectureToCourse(LectureCourseEntity entity);

    List<LectureEntity> getAllLecturesByCourseId(Long cId);

    List<AttendanceEntity> getAllAttendanceByLectureId(Long lId);

    LectureAttendanceEntity addAttendanceToLecture(LectureAttendanceEntity entity);

    AttendanceEntity updateStatusAttendanceId(Long attId);
}

