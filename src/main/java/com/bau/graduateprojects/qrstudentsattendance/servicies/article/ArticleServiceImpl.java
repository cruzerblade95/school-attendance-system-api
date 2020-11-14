package com.bau.graduateprojects.qrstudentsattendance.servicies.article;

import com.bau.graduateprojects.qrstudentsattendance.entities.ArticleEntity;
import com.bau.graduateprojects.qrstudentsattendance.repositories.article.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<ArticleEntity> list() {
        return articleRepository.list();
    }

    @Override
    public ArticleEntity getArticleById(Long id) {
        return articleRepository.getArticleById(id);
    }

    @Override
    public ArticleEntity insert(ArticleEntity articleEntity) {
        return articleRepository.insert(articleEntity);
    }

    @Override
    public void remove(Long id) {
        articleRepository.remove(id);
    }

    @Override
    public long getCount() {
        return articleRepository.getCount();
    }
}
