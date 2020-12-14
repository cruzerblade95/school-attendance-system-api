package com.bau.graduateprojects.qrstudentsattendance.servicies.integration;

import com.bau.graduateprojects.qrstudentsattendance.entities.CourseEntity;
import com.bau.graduateprojects.qrstudentsattendance.entities.StudentEntity;
import com.bau.graduateprojects.qrstudentsattendance.entities.TeacherEntity;
import com.bau.graduateprojects.qrstudentsattendance.repositories.course.CourseRepository;
import com.bau.graduateprojects.qrstudentsattendance.repositories.student.StudentRepository;
import com.bau.graduateprojects.qrstudentsattendance.repositories.teacher.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class IntegrationServiceImpl implements IntegrationService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public IntegrationServiceImpl(StudentRepository studentRepository,
                                  CourseRepository courseRepository,
                                  TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public StudentEntity addCourseToStudent(Long sId, Long cId) {
        StudentEntity student = studentRepository.getById(sId);
        CourseEntity course = courseRepository.getById(cId);
        student.getCourseList().add(course);
        return studentRepository.update(student);
    }

    @Override
    public void removeCourseFromStudent(Long sId, Long cId) {
        StudentEntity student = studentRepository.getById(sId);
        student.getCourseList().removeIf(course -> course.getId().equals(cId));
        studentRepository.update(student);
    }

    @Override
    public TeacherEntity addCourseToTeacher(Long tId, Long cId) {
        TeacherEntity teacher = teacherRepository.getById(tId);
        CourseEntity course = courseRepository.getById(cId);
        teacher.getCourseList().add(course);
        return teacherRepository.update(teacher);
    }

    @Override
    public void removeCourseToTeacher(Long tId, Long cId) {
        TeacherEntity teacher = teacherRepository.getById(tId);
        teacher.getCourseList().removeIf(course -> course.getId().equals(cId));
        teacherRepository.update(teacher);
    }
}
