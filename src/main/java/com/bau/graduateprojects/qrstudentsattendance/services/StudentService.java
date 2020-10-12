package com.bau.graduateprojects.qrstudentsattendance.services;

import com.bau.graduateprojects.qrstudentsattendance.models.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);

    List<Student> listAllStudents();

    Student getStudentByUsername(String username);

    void deleteStudent(String username);

    Student updateStudent(String username, Student student);
}
