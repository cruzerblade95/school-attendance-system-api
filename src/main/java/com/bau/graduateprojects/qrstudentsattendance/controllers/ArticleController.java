package com.bau.graduateprojects.qrstudentsattendance.controllers;

import com.bau.graduateprojects.qrstudentsattendance.entities.ArticleEntity;
import com.bau.graduateprojects.qrstudentsattendance.servicies.article.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/article")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<ArticleEntity> list() {
        return articleService.list();
    }

    @GetMapping("/{id}")
    public ArticleEntity getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }

    @GetMapping("/count")
    public Long getCount() {
        return articleService.getCount();
    }

    @PostMapping
    public ArticleEntity insert(@RequestBody ArticleEntity articleEntity) {
        return articleService.insert(articleEntity);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable Long id) {
        articleService.remove(id);
    }
}
