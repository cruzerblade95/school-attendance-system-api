package com.bau.graduateprojects.qrstudentsattendance.repositories.course;

import com.bau.graduateprojects.qrstudentsattendance.entities.CourseEntity;
import com.bau.graduateprojects.qrstudentsattendance.exception.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class MockCourseRepository implements CourseRepository {

    private final List<CourseEntity> entities = new ArrayList<>();

    @Override
    public List<CourseEntity> list() {
        return entities;
    }

    @Override
    public CourseEntity getById(Long id) {
        return entities.stream()
                .filter(courseEntity -> courseEntity.getId().equals(id))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("course not found with id = " + id));
    }

    @Override
    public Long getCount() {
        return (long) entities.size();
    }

    @Override
    public CourseEntity insert(CourseEntity courseEntity) {
        entities.add(courseEntity);
        return courseEntity;
    }

    @Override
    public CourseEntity update(CourseEntity courseEntity) {
        return new CourseEntity();
    }

    @Override
    public void removeById(Long id) {
        CourseEntity first = entities
                .stream()
                .filter(courseEntity -> courseEntity.getId().equals(id)).findFirst().get();
        entities.remove(first);
    }

    @Override
    public boolean existById(Long courseId) {
        boolean flag = false;
        for (CourseEntity entity : entities) {
            if (entity.getId().equals(courseId)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
