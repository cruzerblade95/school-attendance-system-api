package com.bau.graduateprojects.qrstudentsattendance.repositories.lectureCourse;

import com.bau.graduateprojects.qrstudentsattendance.entities.LectureCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringJpaLectureCourseRepository extends JpaRepository<LectureCourseEntity, Long> {

    boolean existsLectureCourseEntityByLectureIdAndCourseId(Long lId, Long cId);

    Optional<LectureCourseEntity> findLectureCourseEntityByLectureIdAndCourseId(Long lId, Long cId);

    List<LectureCourseEntity> findAllByCourseId(Long cId);
}
