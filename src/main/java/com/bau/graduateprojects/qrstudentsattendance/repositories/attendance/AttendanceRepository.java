package com.bau.graduateprojects.qrstudentsattendance.repositories.attendance;

import com.bau.graduateprojects.qrstudentsattendance.entities.AttendanceEntity;

import java.util.List;

public interface AttendanceRepository {
    List<AttendanceEntity> list();

    AttendanceEntity getAttendanceById(Long id);

    AttendanceEntity insert(AttendanceEntity entity);

    AttendanceEntity update(AttendanceEntity attendanceById);
}
