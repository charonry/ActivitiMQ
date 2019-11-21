package com.charon.boot.mapper;


import com.charon.boot.model.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleMapper {
    void saveArticle(Article article);
    Article getArticleById(@Param("id") long id);
}
