package com.echo.blog.repository;

import com.echo.blog.model.Comment;

import java.util.List;

/**
 * Created by UserA on 7/8/2015.
 */
public interface CommentDao {
    Comment findById(String id);
    List<Comment> findAll();
    List<Comment> findByAuthor(Long Author);
    Comment saveComment(Comment comment);
}
