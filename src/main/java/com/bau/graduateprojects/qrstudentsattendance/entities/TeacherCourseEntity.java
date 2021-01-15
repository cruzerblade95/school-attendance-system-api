package com.bau.graduateprojects.qrstudentsattendance.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "TEACHER_COURSE")
public class TeacherCourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long teacherId;
    private Long courseId;
}
