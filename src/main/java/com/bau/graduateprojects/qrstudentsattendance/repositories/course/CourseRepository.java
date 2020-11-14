package com.bau.graduateprojects.qrstudentsattendance.repositories.course;

import com.bau.graduateprojects.qrstudentsattendance.entities.CourseEntity;

import java.util.List;

public interface CourseRepository {
    List<CourseEntity> list();

    CourseEntity getById(Long id);

    Long getCount();

    CourseEntity insert(CourseEntity courseEntity);

    CourseEntity update(CourseEntity courseEntity);

    void removeById(Long id);
}
