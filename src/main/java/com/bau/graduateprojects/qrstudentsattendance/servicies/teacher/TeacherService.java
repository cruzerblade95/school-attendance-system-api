package com.bau.graduateprojects.qrstudentsattendance.servicies.teacher;

import com.bau.graduateprojects.qrstudentsattendance.entities.TeacherEntity;

import java.util.List;

public interface TeacherService {

    List<TeacherEntity> list();

    TeacherEntity insert(TeacherEntity teacherEntity);

    TeacherEntity getById(Long id);

    TeacherEntity update(TeacherEntity teacherEntity);

    void removeById(Long id);

    TeacherEntity login(String username, String password);
}
