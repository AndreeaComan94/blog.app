package com.echo.blog.repository.mongo;

import com.echo.blog.model.Article;
import com.echo.blog.repository.ArticleDao;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by UserA on 7/9/2015.
 */
@Repository
public class MongoDBArticleRepository implements ArticleDao{

    @Resource
    private MongoOperations operations;

    public Article findById(String id) {
        Query query = query(where("_id").is(new ObjectId(id)));
        return operations.findOne(query, Article.class);
    }

    public Article saveArticle(Article article) {
        operations.save(article);
        return article;
    }

    public List<Article> findByAuthor(Long author) {
        Query query = query(where("authorsList").is(author));
        return operations.find(query, Article.class);
    }
}
