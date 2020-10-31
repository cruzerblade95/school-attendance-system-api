package com.bau.graduateprojects.qrstudentsattendance.repositories.student;

import com.bau.graduateprojects.qrstudentsattendance.entities.StudentEntity;

import java.util.List;


public interface StudentRepository {
    List<StudentEntity> list();

    StudentEntity getByUsername(String username);

    StudentEntity getById(Long id);

    StudentEntity add(StudentEntity studentEntity);

    StudentEntity update(StudentEntity studentEntity);

    void remove(String username);
}
