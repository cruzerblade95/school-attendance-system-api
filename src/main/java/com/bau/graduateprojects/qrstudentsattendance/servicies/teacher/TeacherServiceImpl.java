package com.bau.graduateprojects.qrstudentsattendance.servicies.teacher;

import com.bau.graduateprojects.qrstudentsattendance.entities.TeacherEntity;
import com.bau.graduateprojects.qrstudentsattendance.repositories.teacher.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<TeacherEntity> list() {
        return teacherRepository.list();
    }

    @Override
    public TeacherEntity insert(TeacherEntity teacherEntity) {
        return teacherRepository.insert(teacherEntity);
    }

    @Override
    public TeacherEntity getById(Long id) {
        return teacherRepository.getById(id);
    }

    @Override
    public TeacherEntity update(TeacherEntity teacherEntity) {
        return teacherRepository.update(teacherEntity);
    }

    @Override
    public void removeById(Long id) {
        teacherRepository.removeById(id);
    }

    @Override
    public TeacherEntity login(String username, String password) {
        return teacherRepository.login(username, password);
    }

    @Override
    public Long getCount() {
        return teacherRepository.getCount();
    }
}
