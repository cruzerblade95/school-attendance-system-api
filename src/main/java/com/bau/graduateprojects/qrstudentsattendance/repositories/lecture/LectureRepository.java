package com.bau.graduateprojects.qrstudentsattendance.repositories.lecture;

import com.bau.graduateprojects.qrstudentsattendance.entities.LectureEntity;

import java.util.List;

public interface LectureRepository {
    List<LectureEntity> list();

    LectureEntity getById(Long id);

    LectureEntity insert(LectureEntity lectureEntity);

    void removeById(Long id);
}
