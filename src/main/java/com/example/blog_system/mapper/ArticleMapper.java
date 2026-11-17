package com.example.blog_system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog_system.entity.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper // 关键：让MyBatis识别这个接口
public interface ArticleMapper extends BaseMapper<Article> {
    // 所有基础的CRUD方法已从BaseMapper继承
}