package com.example.blog_system.controller;

import com.example.blog_system.entity.Article;
import com.example.blog_system.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    // 获取所有文章
    @GetMapping
    @ResponseBody
    public List<Article> listArticles() {
        return articleService.getAllArticles();
    }

    // 获取单篇文章
    @GetMapping("/{id}")
    @ResponseBody
    public Article getArticle(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }

    // 创建文章
    @PostMapping
    @ResponseBody
    public Article createArticle(@RequestBody Article article) {return articleService.createArticle(article);
    }

    // 更新文章
    @PutMapping("/{id}")
    @ResponseBody
    public Article updateArticle(@PathVariable Long id, @RequestBody Article article) {
        return articleService.updateArticle(id, article);
    }

    // 删除文章
    @DeleteMapping("/{id}")
    @ResponseBody
    public Boolean deleteArticle(@PathVariable Long id) {
        return articleService.deleteArticle(id);
    }
    @GetMapping("/toTest")
    public String toTestPage(){
        return "test";
    }

    // 调用 AI 获取文章摘要
    @GetMapping("/{id}/ai-summary")
    @ResponseBody
    public String getArticleSummary(@PathVariable Long id) {
        // 1. 用你原本就写好的 getArticleById 查询文章
        Article article = articleService.getArticleById(id);
        if (article == null) {
            return "文章不存在";
        }

        // 2. 构造提示词
        String prompt = "请用50字以内总结这篇博客的内容：" + article.getContent();

        // 3. 直接调用咱们刚写的 AI 工具类
        return com.example.blog_system.util.DeepSeekUtil.askAI(prompt);
    }
}