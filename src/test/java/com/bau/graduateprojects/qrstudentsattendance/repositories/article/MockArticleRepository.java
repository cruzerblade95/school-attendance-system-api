package com.bau.graduateprojects.qrstudentsattendance.repositories.article;

import com.bau.graduateprojects.qrstudentsattendance.entities.ArticleEntity;
import com.bau.graduateprojects.qrstudentsattendance.exception.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class MockArticleRepository implements ArticleRepository {
    private final List<ArticleEntity> entities = new ArrayList<>();

    @Override
    public List<ArticleEntity> list() {
        return entities;
    }

    @Override
    public ArticleEntity getArticleById(Long id) {
        return entities.stream()
                .filter(articleEntity -> articleEntity.getId().equals(id))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("article not found with id = " + id));
    }

    @Override
    public ArticleEntity insert(ArticleEntity articleEntity) {
        if (isNull(articleEntity.getImageUrl()))
            articleEntity.setImageUrl("image link");
        entities.add(articleEntity);
        return articleEntity;
    }

    @Override
    public void remove(Long id) {
        ArticleEntity first = entities
                .stream()
                .filter(articleEntity -> articleEntity.getId().equals(id)).findFirst().get();
        entities.remove(first);
    }

    @Override
    public long getCount() {
        return entities.size();
    }
}
