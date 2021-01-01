package com.bau.graduateprojects.qrstudentsattendance.servicies.student;

import com.bau.graduateprojects.qrstudentsattendance.entities.StudentEntity;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentEntity> list();

    StudentEntity getById(Long id);

    StudentEntity getByUsername(String username);

    StudentEntity insert(StudentEntity studentEntity);

    StudentEntity update(StudentEntity studentEntity);

    void removeById(Long id);

    Long getCount();

    Map<String, String> getStudentsByCourseId(Long id);
}
