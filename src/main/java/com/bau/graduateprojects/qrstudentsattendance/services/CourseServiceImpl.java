package com.bau.graduateprojects.qrstudentsattendance.services;

import com.bau.graduateprojects.qrstudentsattendance.models.Course;
import com.bau.graduateprojects.qrstudentsattendance.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        throwIfNotExist(id);
        return courseRepository.findById(id).get();
    }

    @Override
    public Course updateCourse(Course course, Long id) {
        throwIfNotExist(id);
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = getCourseById(id);
        courseRepository.delete(course);
    }


    private void throwIfNotExist(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new IllegalArgumentException("course id not found");
        }
    }

}
