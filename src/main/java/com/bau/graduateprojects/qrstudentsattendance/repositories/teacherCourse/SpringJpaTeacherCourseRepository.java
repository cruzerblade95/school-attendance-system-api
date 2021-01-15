package com.bau.graduateprojects.qrstudentsattendance.repositories.teacherCourse;

import com.bau.graduateprojects.qrstudentsattendance.entities.TeacherCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringJpaTeacherCourseRepository extends JpaRepository<TeacherCourseEntity, Long> {
    boolean existsTeacherCourseEntityByTeacherIdAndCourseId(Long tId, Long cId);

    Optional<TeacherCourseEntity> findTeacherCourseEntityByTeacherIdAndCourseId(Long tId, Long cId);

    List<TeacherCourseEntity> findAllByTeacherId(Long tId);
}
