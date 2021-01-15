package com.bau.graduateprojects.qrstudentsattendance.repositories.studentCourse;

import com.bau.graduateprojects.qrstudentsattendance.entities.StudentCourseEntity;
import com.bau.graduateprojects.qrstudentsattendance.exception.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentCourseRepositoryImpl implements StudentCourseRepository {
    private final SpringJpaStudentCourseRepository jpaStudentCourseRepository;

    public StudentCourseRepositoryImpl(SpringJpaStudentCourseRepository studentCourseRepository) {
        this.jpaStudentCourseRepository = studentCourseRepository;
    }

    @Override
    public StudentCourseEntity insert(StudentCourseEntity entity) {
        return jpaStudentCourseRepository.save(entity);
    }

    @Override
    public StudentCourseEntity getByStudentIdAndCourseId(Long sId, Long cId) {
        return jpaStudentCourseRepository.findStudentCourseEntityByStudentIdAndCourseId(sId, cId)
                .orElseThrow(() -> new ResourceNotFoundException("Course or student not found with sId = " + sId + " & cId = " + cId));
    }

    @Override
    public void removeById(Long id) {
        jpaStudentCourseRepository.deleteById(id);
    }

    @Override
    public List<StudentCourseEntity> getAllCoursesByStudentId(Long sId) {
        return jpaStudentCourseRepository.findAllByStudentId(sId);
    }

    @Override
    public boolean exist(Long studentId, Long courseId) {
        return jpaStudentCourseRepository.existsStudentCourseEntityByCourseIdAndStudentId(studentId, courseId);
    }

    @Override
    public List<StudentCourseEntity> getAllStudentsByCourseId(Long cId) {
        return jpaStudentCourseRepository.findAllByCourseId(cId);
    }
}
