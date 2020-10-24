package com.bau.graduateprojects.qrstudentsattendance.repositories;

import com.bau.graduateprojects.qrstudentsattendance.models.StudentCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCoursesRepository extends JpaRepository<StudentCourses, Long> {
    List<StudentCourses> getAllByStudentId(Long id);

    List<StudentCourses> getAllByCourseId(Long id);

    void deleteStudentCoursesByCourseIdAndStudentId(Long courseId, Long studentId);

    StudentCourses getByStudentIdAndCourseId(Long studentId, Long courseId);
}
