package com.bau.graduateprojects.qrstudentsattendance.servicies.attendance;

import com.bau.graduateprojects.qrstudentsattendance.entities.AttendanceEntity;

import java.util.List;

public interface AttendanceService {
    List<AttendanceEntity> list();

    AttendanceEntity getAttendanceById(Long id);

    AttendanceEntity insert(AttendanceEntity entity);
}
