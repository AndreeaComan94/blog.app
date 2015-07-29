package com.echo.blog.repository;

import com.echo.blog.model.Article;
import com.echo.blog.model.Comment;


import java.util.List;

/**
 * Created by UserA on 7/8/2015.
 */

public interface ArticleDao {
    Article findById(String id);
    List<Article> findByAuthor(Long Author);
    Article saveArticle(Article article);
    List<Article> findAll();
    Article deleteArticle(String id);
    List<Comment> getComments(String id);
}
