package com.bau.graduateprojects.qrstudentsattendance.repositories.lectureAttendance;

import com.bau.graduateprojects.qrstudentsattendance.entities.AttendanceEntity;
import com.bau.graduateprojects.qrstudentsattendance.entities.LectureAttendanceEntity;

import java.util.List;

public interface LectureAttendanceRepository {
    List<AttendanceEntity> getAllAttendanceByLectureId(Long lId);

    LectureAttendanceEntity addAttendanceToLecture(LectureAttendanceEntity entity);

    AttendanceEntity updateStatusAttendanceId(Long attId);
}
