package com.bau.graduateprojects.qrstudentsattendance.servicies.course;

import com.bau.graduateprojects.qrstudentsattendance.entities.CourseEntity;

import java.util.List;

public interface CourseService {
    List<CourseEntity> list();

    CourseEntity getById(Long id);

    Long getCount();

    CourseEntity insert(CourseEntity courseEntity);

    CourseEntity update(CourseEntity courseEntity);

    void removeById(Long id);
}
