package com.bau.graduateprojects.qrstudentsattendance.repositories.studentCourse;

import com.bau.graduateprojects.qrstudentsattendance.entities.StudentCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringJpaStudentCourseRepository extends JpaRepository<StudentCourseEntity, Long> {
    Optional<StudentCourseEntity> findStudentCourseEntityByStudentIdAndCourseId(Long sId, Long cId);

    List<StudentCourseEntity> findAllByStudentId(Long sId);

    List<StudentCourseEntity> findAllByCourseId(Long cId);

    boolean existsStudentCourseEntityByCourseIdAndStudentId(Long cId, Long sId);
}
