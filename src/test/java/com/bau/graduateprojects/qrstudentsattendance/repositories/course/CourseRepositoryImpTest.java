package com.bau.graduateprojects.qrstudentsattendance.repositories.course;

import com.bau.graduateprojects.qrstudentsattendance.entities.CourseEntity;
import com.bau.graduateprojects.qrstudentsattendance.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseRepositoryImpTest {

    private MockCourseRepository repository;

    @BeforeEach
    void setUp() {
        repository = new MockCourseRepository();
    }

    @Test
    void list() {
        List<CourseEntity> list = repository.list();
        assertTrue(list.isEmpty());
        repository.insert(new CourseEntity());
        assertEquals(1, list.size());
        assertNotNull(list);
    }

    @Test
    void getById() {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(1L);
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class,
                () -> repository.getById(1L));
        assertEquals("course not found with id = 1", exception.getMessage());
        repository.insert(courseEntity);
        CourseEntity entity = repository.getById(1L);
        assertNotNull(entity);
        assertEquals(entity.getId(), courseEntity.getId());
    }

    @Test
    void getCount() {
        repository.insert(new CourseEntity());
        assertEquals(1, repository.getCount());
        repository.insert(new CourseEntity());
        assertEquals(2, repository.getCount());
        repository.insert(new CourseEntity());
        assertEquals(3, repository.getCount());
        repository.insert(new CourseEntity());
        assertEquals(4, repository.getCount());
    }

    @Test
    void insert() {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(1L);
        courseEntity.setSectionNumber(1);
        courseEntity.setTeacherName("teacher");
        CourseEntity insert = repository.insert(courseEntity);
        assertEquals(insert.getId(), courseEntity.getId());
        assertEquals(insert.getSectionNumber(), courseEntity.getSectionNumber());
        assertEquals(insert.getTeacherName(), courseEntity.getTeacherName());
    }

    @Test
    void update() {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(1L);
        CourseEntity update = repository.update(courseEntity);
        assertNotEquals(update, courseEntity);
    }

    @Test
    void removeById() {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(1L);
        repository.insert(courseEntity);
        assertFalse(repository.list().isEmpty());
        repository.removeById(1L);
        assertTrue(repository.list().isEmpty());
    }

    @Test
    void existById() {
        assertFalse(repository.existById(1L));
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(1L);
        repository.insert(courseEntity);
        assertTrue(repository.existById(1L));
    }
}
