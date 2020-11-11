package com.bau.graduateprojects.qrstudentsattendance.repositories.teacher;

import com.bau.graduateprojects.qrstudentsattendance.entities.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringJpaTeacherRepository extends JpaRepository<TeacherEntity, Long> {
    boolean existsByUsername(String username);

    Optional<TeacherEntity> findTeacherEntityByUsername(String username);
}
