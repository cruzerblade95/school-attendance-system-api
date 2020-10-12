package com.bau.graduateprojects.qrstudentsattendance.repositories;

import com.bau.graduateprojects.qrstudentsattendance.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findStudentByUsername(String universityId);

    boolean existsStudentByUsername(String username);
}
