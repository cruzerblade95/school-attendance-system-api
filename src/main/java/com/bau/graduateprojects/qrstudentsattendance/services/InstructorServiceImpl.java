package com.bau.graduateprojects.qrstudentsattendance.services;

import com.bau.graduateprojects.qrstudentsattendance.models.Instructor;
import com.bau.graduateprojects.qrstudentsattendance.repositories.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
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
