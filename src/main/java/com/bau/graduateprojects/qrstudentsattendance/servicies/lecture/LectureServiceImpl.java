package com.bau.graduateprojects.qrstudentsattendance.servicies.lecture;

import com.bau.graduateprojects.qrstudentsattendance.entities.AttendanceEntity;
import com.bau.graduateprojects.qrstudentsattendance.entities.LectureEntity;
import com.bau.graduateprojects.qrstudentsattendance.repositories.lecture.LectureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureServiceImpl implements LectureService {
    private final LectureRepository lectureRepository;

    public LectureServiceImpl(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @Override
    public List<LectureEntity> list() {
        return lectureRepository.list();
    }

    @Override
    public LectureEntity getById(Long id) {
        return lectureRepository.getById(id);
    }

    @Override
    public LectureEntity insert(LectureEntity lectureEntity) {
        return lectureRepository.insert(lectureEntity);
    }

    @Override
    public void removeById(Long id) {
        lectureRepository.removeById(id);
    }

    @Override
    public List<AttendanceEntity> getAttendanceByDate(String date) {
        return lectureRepository.getAttendanceByDate(date);
    }
}
