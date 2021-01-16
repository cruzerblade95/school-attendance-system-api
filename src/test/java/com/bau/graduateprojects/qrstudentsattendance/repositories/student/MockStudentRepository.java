package com.bau.graduateprojects.qrstudentsattendance.repositories.student;

import com.bau.graduateprojects.qrstudentsattendance.entities.StudentEntity;
import com.bau.graduateprojects.qrstudentsattendance.exception.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class MockStudentRepository implements StudentRepository {
    private final List<StudentEntity> entities = new ArrayList<>();

    @Override
    public List<StudentEntity> list() {
        return entities;
    }

    @Override
    public StudentEntity getByUsername(String username) {
        return entities.stream()
                .filter(studentEntity -> studentEntity.getUsername().equals(username))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("student not found with username = " + username));
    }

    @Override
    public StudentEntity insert(StudentEntity studentEntity) {
        entities.add(studentEntity);
        return studentEntity;
    }

    @Override
    public StudentEntity getById(Long id) {
        return entities.stream()
                .filter(studentEntity -> studentEntity.getId().equals(id))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("student not found with id = " + id));
    }

    @Override
    public StudentEntity update(StudentEntity studentEntity) {
        return new StudentEntity();
    }

    @Override
    public void removeById(Long id) {
        StudentEntity first = entities
                .stream()
                .filter(studentEntity -> studentEntity.getId().equals(id)).findFirst().get();
        entities.remove(first);

    }

    @Override
    public Long getCount() {
        return (long) entities.size();
    }

    @Override
    public boolean existById(Long studentId) {
        boolean flag = false;
        for (StudentEntity entity : entities) {
            if (entity.getId().equals(studentId)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
