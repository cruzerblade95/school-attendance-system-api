package com.bau.graduateprojects.qrstudentsattendance.repositories.attendance;

import com.bau.graduateprojects.qrstudentsattendance.entities.AttendanceEntity;
import com.bau.graduateprojects.qrstudentsattendance.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AttendanceRepositoryImplTest {
    private MockAttendanceRepository repository;

    @BeforeEach
    void setUp() {
        repository = new MockAttendanceRepository();
    }

    @Test
    void list() {
        List<AttendanceEntity> list = repository.list();
        assertTrue(list.isEmpty());
        repository.insert(new AttendanceEntity());
        assertEquals(1, list.size());
        assertNotNull(list);
    }

    @Test
    void getAttendanceById() {
        AttendanceEntity attendanceEntity = new AttendanceEntity();
        attendanceEntity.setId(1L);
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class,
                () -> repository.getAttendanceById(1L));
        assertEquals("attendance not found with id = 1", exception.getMessage());
        repository.insert(attendanceEntity);
        AttendanceEntity entity = repository.getAttendanceById(1L);
        assertNotNull(entity);
        assertEquals(entity.getId(), attendanceEntity.getId());
    }

    @Test
    void insert() {
        AttendanceEntity attendanceEntity = new AttendanceEntity();
        attendanceEntity.setId(1L);
        attendanceEntity.setStatus("NO");
        attendanceEntity.setStudentUsername("username");
        AttendanceEntity insert = repository.insert(attendanceEntity);
        assertEquals(insert.getId(), attendanceEntity.getId());
        assertEquals(insert.getStatus(), attendanceEntity.getStatus());
        assertEquals(insert.getStudentUsername(), attendanceEntity.getStudentUsername());
    }

    @Test
    void update() {
        AttendanceEntity attendanceEntity = new AttendanceEntity();
        attendanceEntity.setStatus("NO");
        AttendanceEntity update = repository.update(attendanceEntity);
        assertEquals("YES", update.getStatus());
    }
}
