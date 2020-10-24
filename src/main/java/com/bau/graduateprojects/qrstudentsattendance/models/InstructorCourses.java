package com.bau.graduateprojects.qrstudentsattendance.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class InstructorCourses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long instructorId;
    private Long courseId;
}
