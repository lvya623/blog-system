package com.example.blog_system.service; // 请将`com.example.blog_system`替换为你的实际包名

import com.example.blog_system.entity.Article;
import com.example.blog_system.mapper.ArticleMapper;
import com.example.blog_system.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // 此注解必须添加，用于声明这是一个Spring管理的Service组件
public class ArticleServiceImpl implements ArticleService {

    @Autowired // 此注解必须添加，用于自动注入Mapper实例
    private ArticleMapper articleMapper;

    @Override
    public List<Article> getAllArticles() {
        // 查询所有文章
        return articleMapper.selectList(null);
    }

    @Override
    public Article getArticleById(Long id) {
        // 根据ID查询单篇文章
        return articleMapper.selectById(id);
    }

    @Override
    public Article createArticle(Article article) {
        // 插入新文章，MyBatis-Plus会自动回填生成的主键ID（如果你的id是自增的）
        articleMapper.insert(article);
        return article;
    }

    @Override
    public Article updateArticle(Long id, Article article) {
        // 更新文章，确保ID被设置
        article.setId(id);
        articleMapper.updateById(article);
        return article;
    }

    @Override
    public boolean deleteArticle(Long id) {
        // 根据ID删除，deleteById方法返回受影响的行数，大于0表示删除成功
        int affectedRows = articleMapper.deleteById(id);
        return affectedRows > 0;
    }

}