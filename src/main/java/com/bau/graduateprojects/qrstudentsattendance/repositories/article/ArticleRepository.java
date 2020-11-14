package com.bau.graduateprojects.qrstudentsattendance.repositories.article;

import com.bau.graduateprojects.qrstudentsattendance.entities.ArticleEntity;

import java.util.List;

public interface ArticleRepository {
    List<ArticleEntity> list();

    ArticleEntity getArticleById(Long id);

    ArticleEntity insert(ArticleEntity articleEntity);

    void remove(Long id);

    long getCount();
}
