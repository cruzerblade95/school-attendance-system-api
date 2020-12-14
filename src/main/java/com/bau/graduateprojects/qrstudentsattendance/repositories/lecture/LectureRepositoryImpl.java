package com.bau.graduateprojects.qrstudentsattendance.repositories.lecture;

import com.bau.graduateprojects.qrstudentsattendance.entities.LectureEntity;
import com.bau.graduateprojects.qrstudentsattendance.exception.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LectureRepositoryImpl implements LectureRepository {
    private final SpringJpaLectureRepository repository;

    public LectureRepositoryImpl(SpringJpaLectureRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LectureEntity> list() {
        return repository.findAll();
    }

    @Override
    public LectureEntity getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("lecture not found with id = " + id));
    }

    @Override
    public LectureEntity insert(LectureEntity lectureEntity) {
        return repository.save(lectureEntity);
    }

    @Override
    public void removeById(Long id) {
        repository.deleteById(id);
    }


}
