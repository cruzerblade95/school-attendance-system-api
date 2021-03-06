package com.bau.graduateprojects.qrstudentsattendance.repositories.lectureAttendance;

import com.bau.graduateprojects.qrstudentsattendance.entities.LectureAttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringJpaLectureAttendanceRepository extends JpaRepository<LectureAttendanceEntity, Long> {
    List<LectureAttendanceEntity> findAllByLectureId(Long lId);

    LectureAttendanceEntity findLectureAttendanceEntityByAttendanceId(Long lId);
}
