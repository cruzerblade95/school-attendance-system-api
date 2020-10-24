package com.bau.graduateprojects.qrstudentsattendance.services;

import com.bau.graduateprojects.qrstudentsattendance.models.StudentCourses;
import com.bau.graduateprojects.qrstudentsattendance.repositories.StudentCoursesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCoursesServiceImpl implements StudentCoursesService {
    private final StudentCoursesRepository studentCoursesRepository;

    public StudentCoursesServiceImpl(StudentCoursesRepository studentCoursesRepository) {
        this.studentCoursesRepository = studentCoursesRepository;
    }

    @Override
    public List<StudentCourses> getAllCoursesByStudentId(Long id) {
        return studentCoursesRepository.getAllByStudentId(id);
    }

    @Override
    public List<StudentCourses> getAllStudentsByCourseId(Long id) {
        return studentCoursesRepository.getAllByCourseId(id);
    }

    @Override
    public StudentCourses addNewStudentCourses(StudentCourses studentCourses) {
        return studentCoursesRepository.save(studentCourses);
    }

    @Override
    public void deleteStudentCourses(Long courseId, Long studentId) {
        studentCoursesRepository.deleteStudentCoursesByCourseIdAndStudentId(courseId, studentId);
    }

    @Override
    public StudentCourses addNewAbsence(Long studentId, Long courseId) {
        StudentCourses studentCourse = studentCoursesRepository
                .getByStudentIdAndCourseId(studentId, courseId);

        int oldValue = studentCourse.getAbsenceNumber();
        studentCourse.setAbsenceNumber(oldValue + 1);

        return studentCoursesRepository.save(studentCourse);
    }
}
