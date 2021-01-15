package com.bau.graduateprojects.qrstudentsattendance.repositories.secret;

import com.bau.graduateprojects.qrstudentsattendance.entities.SecretKeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringJpaSecretRepository extends JpaRepository<SecretKeyEntity, Long> {
    boolean existsSecretKeyEntityByCourseId(Long courseId);

    SecretKeyEntity findSecretKeyEntityByCourseId(Long courseId);
}
