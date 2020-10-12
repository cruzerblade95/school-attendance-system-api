package com.bau.graduateprojects.qrstudentsattendance.controllers;

import com.bau.graduateprojects.qrstudentsattendance.models.Instructor;
import com.bau.graduateprojects.qrstudentsattendance.services.InstructorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        return instructorService.createInstructor(instructor);
    }

    @GetMapping
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @GetMapping("/{id}")
    public Instructor getInstructorById(@PathVariable Long id) {
        return instructorService.getInstructorById(id);
    }

    @PutMapping("/{id}")
    public Instructor updateInstructor(@RequestBody Instructor instructor, @PathVariable Long id) {
        return instructorService.updateInstructor(instructor, id);
    }

    @DeleteMapping("/{id}")
    public void deleteInstructor(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
    }

}
