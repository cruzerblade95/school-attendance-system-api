package com.bau.graduateprojects.qrstudentsattendance.repositories.teacher;

import com.bau.graduateprojects.qrstudentsattendance.entities.TeacherEntity;
import com.bau.graduateprojects.qrstudentsattendance.exception.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class MockTeacherRepository implements TeacherRepository {
    private final List<TeacherEntity> entities = new ArrayList<>();

    @Override
    public List<TeacherEntity> list() {
        return entities;
    }

    @Override
    public TeacherEntity insert(TeacherEntity teacherEntity) {
        entities.add(teacherEntity);
        return teacherEntity;
    }

    @Override
    public TeacherEntity getById(Long id) {
        return entities.stream()
                .filter(teacherEntity -> teacherEntity.getId().equals(id))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("teacher not found with id = " + id));
    }

    @Override
    public TeacherEntity update(TeacherEntity teacherEntity) {
        return new TeacherEntity();
    }

    @Override
    public void removeById(Long id) {
        TeacherEntity first = entities
                .stream()
                .filter(teacherEntity -> teacherEntity.getId().equals(id)).findFirst().get();
        entities.remove(first);
    }

    @Override
    public TeacherEntity login(String username, String password) {
        return getByUsername(username);
    }

    @Override
    public Long getCount() {
        return (long) entities.size();
    }

    @Override
    public TeacherEntity getByUsername(String username) {
        return entities.stream()
                .filter(teacherEntity -> teacherEntity.getUsername().equals(username))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("teacher not found with username = " + username));
    }

    @Override
    public boolean existById(Long teacherId) {
        boolean flag = false;
        for (TeacherEntity entity : entities) {
            if (entity.getId().equals(teacherId)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
