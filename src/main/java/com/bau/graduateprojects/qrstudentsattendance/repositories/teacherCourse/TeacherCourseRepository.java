package com.bau.graduateprojects.qrstudentsattendance.repositories.teacherCourse;

import com.bau.graduateprojects.qrstudentsattendance.entities.TeacherCourseEntity;

import java.util.List;

public interface TeacherCourseRepository {
    TeacherCourseEntity insert(TeacherCourseEntity entity);

    boolean exist(Long teacherId, Long courseId);

    TeacherCourseEntity getByTeacherIdAndCourseId(Long tId, Long cId);

    void removeById(Long id);

    List<TeacherCourseEntity> getAllCoursesByTeacherId(Long tId);
}
