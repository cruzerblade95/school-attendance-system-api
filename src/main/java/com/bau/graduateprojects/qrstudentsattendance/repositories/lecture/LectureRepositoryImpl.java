package com.bau.graduateprojects.qrstudentsattendance.repositories.lecture;

import com.bau.graduateprojects.qrstudentsattendance.entities.LectureEntity;
import com.bau.graduateprojects.qrstudentsattendance.exception.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LectureRepositoryImpl implements LectureRepository {
    private final SpringJpaLectureRepository jpaLectureRepository;

    public LectureRepositoryImpl(SpringJpaLectureRepository repository) {
        this.jpaLectureRepository = repository;
    }

    @Override
    public List<LectureEntity> list() {
        return jpaLectureRepository.findAll();
    }

    @Override
    public LectureEntity getById(Long id) {
        return jpaLectureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("lecture not found with id = " + id));
    }

    @Override
    public LectureEntity insert(LectureEntity lectureEntity) {

        return jpaLectureRepository.save(lectureEntity);
    }

    @Override
    public void removeById(Long id) {
        jpaLectureRepository.deleteById(id);
    }

    @Override
    public boolean existById(Long lectureId) {
        return jpaLectureRepository.existsById(lectureId);
    }
}
