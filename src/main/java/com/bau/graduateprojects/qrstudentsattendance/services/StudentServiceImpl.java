package com.bau.graduateprojects.qrstudentsattendance.services;

import com.bau.graduateprojects.qrstudentsattendance.models.Student;
import com.bau.graduateprojects.qrstudentsattendance.repositories.StudentRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        throwIfNull(student, "student");
        encodePassword(student);
        return studentRepository.save(student);
    }

    public List<Student> listAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentByUsername(String username) {
        return studentRepository.findStudentByUsername(username);
    }

    private void encodePassword(Student student) {
        String encodedPassword = new BCryptPasswordEncoder()
                .encode(student.getPassword());
        student.setPassword(encodedPassword);
    }

    private void throwIfNull(Object o, String fieldName) {
        if (isNull(o))
            throw new IllegalArgumentException(fieldName + " must not be null");
    }
}
