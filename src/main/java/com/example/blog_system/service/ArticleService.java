package com.example.blog_system.service;

import com.example.blog_system.entity.Article;
import java.util.List;

public interface ArticleService {
    // 获取所有文章列表
    List<Article> getAllArticles();

    // 根据ID获取文章
    Article getArticleById(Long id);

    // 创建文章
    Article createArticle(Article article);

    // 更新文章
    Article updateArticle(Long id, Article article);

    // 删除文章
    boolean deleteArticle(Long id);
}