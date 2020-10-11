package com.bau.graduateprojects.qrstudentsattendance.services;

import com.bau.graduateprojects.qrstudentsattendance.models.Student;
import com.bau.graduateprojects.qrstudentsattendance.repositories.MockStudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentServiceTest {

    private StudentService studentService;

    @BeforeEach
    void setUp() {
        MockStudentRepository mockStudentRepository = new MockStudentRepository();
        studentService = new StudentServiceImpl(mockStudentRepository);
    }

    @Test
    void givenNullStudentWhenCreateStudentThenFail() {
        Student student = null;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> studentService.createStudent(student));
        assertEquals("student must not be null", exception.getMessage());
    }

    Student makeStudent() {
        Student student = new Student();
        student.setUsername("username");
        student.setPassword("password");
        student.setName("name");
        student.setBirthDay(LocalDate.now());
        student.setEmail("email");
        return student;
    }
}
