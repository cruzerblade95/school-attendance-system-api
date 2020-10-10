package com.bau.graduateprojects.qrstudentsattendance.services;

import com.bau.graduateprojects.qrstudentsattendance.models.Student;
import com.bau.graduateprojects.qrstudentsattendance.repositories.StudentRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        encodePassword(student);
        return studentRepository.save(student);
    }

    private void encodePassword(Student student) {
        String encodedPassword = new BCryptPasswordEncoder()
                .encode(student.getPassword());
        student.setPassword(encodedPassword);
    }
}
