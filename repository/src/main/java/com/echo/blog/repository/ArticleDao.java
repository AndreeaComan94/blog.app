package com.echo.blog.repository;

import com.echo.blog.model.Article;


import java.util.List;

/**
 * Created by UserA on 7/8/2015.
 */

public interface ArticleDao {
    Article findById(String id);
    List<Article> findByAuthor(Long Author);
    Article saveArticle(Article article);
}
