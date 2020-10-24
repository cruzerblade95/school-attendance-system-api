package com.bau.graduateprojects.qrstudentsattendance.services;

import com.bau.graduateprojects.qrstudentsattendance.models.Instructor;

import java.util.List;

public interface InstructorService {

    Instructor createInstructor(Instructor instructor);

    List<Instructor> getAllInstructors();

    Instructor getInstructorById(Long id);

    Instructor updateInstructor(Instructor instructor, Long id);

    void deleteInstructor(Long id);
}
