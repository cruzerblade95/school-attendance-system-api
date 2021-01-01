package com.bau.graduateprojects.qrstudentsattendance.controllers;

import com.bau.graduateprojects.qrstudentsattendance.entities.AttendanceEntity;
import com.bau.graduateprojects.qrstudentsattendance.entities.LectureEntity;
import com.bau.graduateprojects.qrstudentsattendance.servicies.lecture.LectureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lecture")
public class LectureController {
    private final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping
    public List<LectureEntity> list() {
        return lectureService.list();
    }

    @GetMapping("/{id}")
    public LectureEntity getById(@PathVariable Long id) {
        return lectureService.getById(id);
    }

    @GetMapping("/attendance/{date}")
    public List<AttendanceEntity> getAttendanceByDate(@PathVariable String date) {
        return lectureService.getAttendanceByDate(date);
    }

    @PostMapping
    public LectureEntity insert(@RequestBody LectureEntity lectureEntity) {
        return lectureService.insert(lectureEntity);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable Long id) {
        lectureService.removeById(id);
    }
}
