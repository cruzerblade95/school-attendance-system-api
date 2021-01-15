package com.bau.graduateprojects.qrstudentsattendance.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "LECTURE_COURSE")
public class LectureCourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long lectureId;
    private Long courseId;

}
