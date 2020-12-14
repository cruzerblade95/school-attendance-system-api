package com.bau.graduateprojects.qrstudentsattendance.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "LECTURE")
public class LectureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String date;
    private String startHour;
    private String endHour;
    @OneToMany
    private List<AttendanceEntity> attendanceList;
}
