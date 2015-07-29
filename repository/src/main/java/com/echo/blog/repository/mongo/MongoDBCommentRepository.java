package com.echo.blog.repository.mongo;

import com.echo.blog.model.Comment;
import com.echo.blog.repository.CommentDao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by UserA on 7/10/2015.
 */
@Repository
public class MongoDBCommentRepository implements CommentDao{
    @Resource
    private MongoOperations operations;

    public Comment findById(String id) {
        Query query = query(where("_id").is(new ObjectId(id)));
        return operations.findOne(query, Comment.class);
    }

    public Comment saveComment(Comment comment) {
        operations.save(comment);
        return comment;
    }

    public List<Comment> findByAuthor(Long author) {
        Query query = query(where("commentsList").is(author));
        return operations.find(query, Comment.class);
    }

    public List<Comment> findAll() {
        return operations.findAll(Comment.class);
    }
}
