package com.bau.graduateprojects.qrstudentsattendance.repositories.student;

import com.bau.graduateprojects.qrstudentsattendance.entities.StudentEntity;
import com.bau.graduateprojects.qrstudentsattendance.exception.ResourceNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private final SpringJpaStudentRepository jpaRepository;

    public StudentRepositoryImpl(SpringJpaStudentRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public StudentEntity getByUsername(String username) {
        return jpaRepository.findStudentEntityByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with username = " + username));
    }

    @Override
    public StudentEntity getById(Long id) {
        return jpaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id = " + id));
    }

    @Override
    public StudentEntity add(StudentEntity studentEntity) {

        studentEntity.setPassword(new BCryptPasswordEncoder()
                .encode(studentEntity.getPassword()));

        return jpaRepository.save(studentEntity);
    }

    @Override
    public StudentEntity update(StudentEntity studentEntity) {
        return jpaRepository.save(studentEntity);
    }

    @Override
    @Transactional
    public void remove(String username) {
        jpaRepository.deleteStudentEntityByUsername(username);
    }

    @Override
    public List<StudentEntity> list() {
        return jpaRepository.findAll();
    }

}
