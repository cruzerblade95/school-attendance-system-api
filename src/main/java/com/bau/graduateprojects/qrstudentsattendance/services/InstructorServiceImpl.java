package com.bau.graduateprojects.qrstudentsattendance.services;

import com.bau.graduateprojects.qrstudentsattendance.models.Course;
import com.bau.graduateprojects.qrstudentsattendance.models.Instructor;
import com.bau.graduateprojects.qrstudentsattendance.repositories.CourseRepository;
import com.bau.graduateprojects.qrstudentsattendance.repositories.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;
    private final CourseRepository courseRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository, CourseRepository courseRepository) {
        this.instructorRepository = instructorRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor getInstructorById(Long id) {
        throwIfNotExist(id);
        return instructorRepository.findById(id).get();
    }

    @Override
    public Instructor updateInstructor(Instructor instructor, Long id) {
        throwIfNotExist(id);
        return instructorRepository.save(instructor);
    }

    @Override
    public void deleteInstructor(Long id) {
        Instructor instructor = getInstructorById(id);
        instructorRepository.delete(instructor);
    }

    private void throwIfNotExist(Long id) {
        if (!instructorRepository.existsById(id)) {
            throw new IllegalArgumentException("course id not found");
        }
    }
}
