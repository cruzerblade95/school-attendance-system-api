package com.bau.graduateprojects.qrstudentsattendance.services;

import com.bau.graduateprojects.qrstudentsattendance.models.Student;
import com.bau.graduateprojects.qrstudentsattendance.repositories.StudentRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StudentServiceTest {

    private final StudentRepository studentRepository = mock(StudentRepository.class);
    private final StudentServiceImpl studentService = new StudentServiceImpl(studentRepository);

    @Test
    void givenNullStudentWhenCreateStudentThenFail() {
        Student student = null;
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> studentService.createStudent(student));
        assertEquals("student object must not be null", exception.getMessage());
    }

    // TODO make sure of this way wit someone
    @Test
    void givenStudentAndSaveItWhenGetAllStudentThenReturnListWithSavedStudents() {
        Student student = makeStudent();
        when(studentRepository.save(student)).thenReturn(student);
        ArrayList<Student> students = new ArrayList<>();
        students.add(student);
        when(studentRepository.findAll()).thenReturn(students);
//        studentService.createStudent(student);

        List<Student> list = studentService.listAllStudents();
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals(student, list.get(0));
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
