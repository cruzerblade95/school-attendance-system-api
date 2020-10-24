package com.bau.graduateprojects.qrstudentsattendance.services;

import com.bau.graduateprojects.qrstudentsattendance.models.InstructorCourses;
import com.bau.graduateprojects.qrstudentsattendance.repositories.InstructorCoursesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorCoursesServiceImpl implements InstructorCoursesService {
    private final InstructorCoursesRepository instructorCoursesRepository;

    public InstructorCoursesServiceImpl(InstructorCoursesRepository instructorCoursesRepository) {
        this.instructorCoursesRepository = instructorCoursesRepository;
    }

    @Override
    public List<InstructorCourses> getAll() {
        return instructorCoursesRepository.findAll();
    }

    @Override
    public List<InstructorCourses> getAllCoursesByInstructorId(Long id) {
        return instructorCoursesRepository.getAllByInstructorId(id);
    }

    @Override
    public List<InstructorCourses> getAllInstructorsByCourseId(Long id) {
        return instructorCoursesRepository.getAllByCourseId(id);
    }
}
