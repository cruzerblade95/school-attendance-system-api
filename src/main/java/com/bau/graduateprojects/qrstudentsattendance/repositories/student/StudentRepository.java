package com.bau.graduateprojects.qrstudentsattendance.repositories.student;

import com.bau.graduateprojects.qrstudentsattendance.entities.StudentEntity;

import java.util.List;

public interface StudentRepository {
    List<StudentEntity> list();

    StudentEntity getByUsername(String username);

    StudentEntity insert(StudentEntity studentEntity);

    StudentEntity getById(Long id);

    StudentEntity update(StudentEntity studentEntity);

    void removeById(Long id);

    Long getCount();

    boolean existById(Long studentId);
}
