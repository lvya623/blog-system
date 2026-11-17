package com.example.blog_system.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("article") // 对应数据库表名
public class Article {
    @TableId(type = IdType.AUTO) // 主键自增
    private Long id;
    private String title;
    private String content;
    private Long authorId;
    private Long categoryId;

    @TableField(fill = FieldFill.INSERT) // 插入时自动填充
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE) // 插入/更新时自动填充
    private LocalDateTime updateTime;
}