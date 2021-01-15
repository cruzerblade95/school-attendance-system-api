package com.bau.graduateprojects.qrstudentsattendance.repositories.lectureCourse;

import com.bau.graduateprojects.qrstudentsattendance.entities.LectureCourseEntity;

import java.util.List;

public interface LectureCourseRepository {
    LectureCourseEntity insert(LectureCourseEntity entity);

    boolean exist(Long lectureId, Long courseId);

    LectureCourseEntity getByLectureIdAndCourseId(Long lId, Long cId);

    void removeById(Long id);

    List<LectureCourseEntity> getAllLecturesByCourseId(Long cId);
}
