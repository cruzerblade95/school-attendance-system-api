package com.bau.graduateprojects.qrstudentsattendance.services;

import com.bau.graduateprojects.qrstudentsattendance.models.Student;
import com.bau.graduateprojects.qrstudentsattendance.repositories.StudentRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.requireNonNull;

@Service
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        requireNonNull(student, "student object must not be null");
        student.setPassword(encodePassword(student.getPassword()));
        return studentRepository.save(student);
    }

    @Override
    public List<Student> listAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentByUsername(String username) {
        return studentRepository.findStudentByUsername(username);
    }

    @Override
    public void deleteStudent(String username) {
        Student student = getStudentByUsername(username);
        studentRepository.delete(student);
    }

    @Override
    public Student updateStudent(String username, Student newStudent) {
        Student oldStudent = getStudentByUsername(username);

        newStudent
                .setPassword(updatePassword(oldStudent.getPassword(),
                        newStudent.getPassword()));

        return studentRepository.save(newStudent);
    }

    private String updatePassword(String oldPassword, String newPassword) {
        return !isMatchesPassword(oldPassword, newPassword) ?
                new BCryptPasswordEncoder()
                        .encode(newPassword) : oldPassword;

    }

    private boolean isMatchesPassword(String old, String latest) {
        return new BCryptPasswordEncoder()
                .matches(old, latest);
    }


    private String encodePassword(String password) {
        return new BCryptPasswordEncoder()
                .encode(password);

    }
}
