package com.bau.graduateprojects.qrstudentsattendance.repositories.attendance;

import com.bau.graduateprojects.qrstudentsattendance.entities.AttendanceEntity;
import com.bau.graduateprojects.qrstudentsattendance.exception.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class MockAttendanceRepository implements AttendanceRepository {
    private final List<AttendanceEntity> entities = new ArrayList<>();

    @Override
    public List<AttendanceEntity> list() {
        return entities;
    }

    @Override
    public AttendanceEntity getAttendanceById(Long id) {
        return entities.stream()
                .filter(attendanceEntity -> attendanceEntity.getId().equals(id))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("attendance not found with id = " + id));
    }

    @Override
    public AttendanceEntity insert(AttendanceEntity entity) {
        entities.add(entity);
        return entity;
    }

    @Override
    public AttendanceEntity update(AttendanceEntity attendanceById) {
        attendanceById.setStatus("YES");
        return attendanceById;
    }
}
