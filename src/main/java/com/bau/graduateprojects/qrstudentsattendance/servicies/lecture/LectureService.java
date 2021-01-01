package com.bau.graduateprojects.qrstudentsattendance.servicies.lecture;

import com.bau.graduateprojects.qrstudentsattendance.entities.AttendanceEntity;
import com.bau.graduateprojects.qrstudentsattendance.entities.LectureEntity;

import java.util.List;

public interface LectureService {
    List<LectureEntity> list();

    LectureEntity getById(Long id);

    LectureEntity insert(LectureEntity lectureEntity);

    void removeById(Long id);

    List<AttendanceEntity> getAttendanceByDate(String date);
}
