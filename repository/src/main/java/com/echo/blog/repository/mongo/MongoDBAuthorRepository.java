package com.echo.blog.repository.mongo;

import com.echo.blog.model.Article;
import com.echo.blog.model.Author;
import com.echo.blog.repository.AuthorDao;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.management.ObjectName;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by UserA on 7/9/2015.
 */
@Repository
public class MongoDBAuthorRepository {}/*implements AuthorDao{
    @Resource
    private MongoOperations operations;

    public Author findById(String id){
        Query query = query(where("_id").is(new ObjectId(id)));
        return operations.findOne(query, Author.class);
    }
    public Author findByName(String name){
        Query query= query(where("_name").is(new ObjectName(name)));
        return operations.findOne(query, Author.class);
    }

    public Author saveAuthor(Author author){
        operations.save(author);
        return author;
    }
}*/
