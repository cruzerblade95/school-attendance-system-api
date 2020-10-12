package com.bau.graduateprojects.qrstudentsattendance.repositories;

import com.bau.graduateprojects.qrstudentsattendance.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
