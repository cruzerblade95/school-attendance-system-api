package com.bau.graduateprojects.qrstudentsattendance.repositories;

import com.bau.graduateprojects.qrstudentsattendance.models.InstructorCourses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstructorCoursesRepository extends JpaRepository<InstructorCourses, Long> {
    List<InstructorCourses> getAllByInstructorId(Long id);

    List<InstructorCourses> getAllByCourseId(Long id);
}
