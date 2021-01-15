package com.bau.graduateprojects.qrstudentsattendance.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "STUDENT_COURSE")
public class StudentCourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long studentId;
    private Long courseId;
}
