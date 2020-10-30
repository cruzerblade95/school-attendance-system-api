package com.bau.graduateprojects.qrstudentsattendance.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Table(name = "LECTURE")
public class LectureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate date;
    private LocalTime startHour;
    private LocalTime endHour;
    @ManyToOne
    private CourseEntity course;
    @OneToOne
    private TeacherEntity teacher;
    @OneToMany
    private List<AttendanceEntity> attendanceList;

}
