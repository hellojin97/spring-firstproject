package me.hjkim.firstproject.controller;

import me.hjkim.firstproject.dto.ArticleForm;
import me.hjkim.firstproject.entity.Article;
import me.hjkim.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;    // Repository 객체 선언

    @GetMapping("/articles/new")
    public String newArticleForm() {

        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        System.out.println(form.toString());
        //1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        System.out.println("article.toString() = " + article.toString());
        //2. Repository로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);
        System.out.println("saved = " + saved.toString());
        return "";
    }
}
