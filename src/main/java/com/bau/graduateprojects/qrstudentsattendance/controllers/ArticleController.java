package com.bau.graduateprojects.qrstudentsattendance.controllers;

import com.bau.graduateprojects.qrstudentsattendance.entities.ArticleEntity;
import com.bau.graduateprojects.qrstudentsattendance.repositories.article.ArticleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/article")
public class ArticleController {
    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    @GetMapping
    public List<ArticleEntity> list() {
        return articleRepository.list();
    }

    @GetMapping("/{id}")
    public ArticleEntity getArticleById(@PathVariable Long id){
        return articleRepository.getArticleById(id);
    }

    @PostMapping
    public ArticleEntity insert(@RequestBody ArticleEntity articleEntity){
        return articleRepository.insert(articleEntity);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable Long id){
        articleRepository.remove(id);
    }
}
