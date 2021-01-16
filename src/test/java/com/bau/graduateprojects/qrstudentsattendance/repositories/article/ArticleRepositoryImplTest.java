package com.bau.graduateprojects.qrstudentsattendance.repositories.article;

import com.bau.graduateprojects.qrstudentsattendance.entities.ArticleEntity;
import com.bau.graduateprojects.qrstudentsattendance.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArticleRepositoryImplTest {

    private MockArticleRepository repository;

    @BeforeEach
    void setUp() {
        repository = new MockArticleRepository();
    }

    @Test
    void list() {
        List<ArticleEntity> list = repository.list();
        assertTrue(list.isEmpty());
        repository.insert(new ArticleEntity());
        assertEquals(1, list.size());
        assertNotNull(list);
    }

    @Test
    void getArticleById() {
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setId(1L);
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class,
                () -> repository.getArticleById(1L));
        assertEquals("article not found with id = 1", exception.getMessage());
        repository.insert(articleEntity);
        ArticleEntity articleById = repository.getArticleById(1L);
        assertNotNull(articleById);
        assertEquals(articleById.getId(), articleEntity.getId());
    }

    @Test
    void insert() {
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setId(1L);
        articleEntity.setTitle("title");
        articleEntity.setContent("content");
        ArticleEntity insert = repository.insert(articleEntity);
        assertEquals(insert.getId(), articleEntity.getId());
        assertEquals(insert.getTitle(), articleEntity.getTitle());
        assertEquals(insert.getContent(), articleEntity.getContent());
        assertEquals(insert.getImageUrl(), articleEntity.getImageUrl());

    }

    @Test
    void remove() {
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setId(1L);
        repository.insert(articleEntity);
        assertFalse(repository.list().isEmpty());
        repository.remove(1L);
        assertTrue(repository.list().isEmpty());
    }

    @Test
    void getCount() {
        repository.insert(new ArticleEntity());
        assertEquals(1, repository.getCount());
        repository.insert(new ArticleEntity());
        assertEquals(2, repository.getCount());
        repository.insert(new ArticleEntity());
        assertEquals(3, repository.getCount());
        repository.insert(new ArticleEntity());
        assertEquals(4, repository.getCount());
    }
}
