package com.bau.graduateprojects.qrstudentsattendance.repositories.studentCourse;

import com.bau.graduateprojects.qrstudentsattendance.entities.StudentCourseEntity;

import java.util.List;

public interface StudentCourseRepository {
    StudentCourseEntity insert(StudentCourseEntity entity);

    StudentCourseEntity getByStudentIdAndCourseId(Long sId, Long cId);

    void removeById(Long id);

    List<StudentCourseEntity> getAllCoursesByStudentId(Long sId);

    boolean exist(Long studentId, Long courseId);

    List<StudentCourseEntity> getAllStudentsByCourseId(Long cId);
}
