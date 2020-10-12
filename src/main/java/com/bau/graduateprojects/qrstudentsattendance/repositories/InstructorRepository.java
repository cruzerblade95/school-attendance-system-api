package com.bau.graduateprojects.qrstudentsattendance.repositories;

import com.bau.graduateprojects.qrstudentsattendance.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
