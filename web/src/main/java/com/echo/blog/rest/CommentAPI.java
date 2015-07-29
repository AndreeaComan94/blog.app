package com.echo.blog.rest;

import com.echo.blog.model.Comment;
import com.echo.blog.repository.CommentDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by UserA on 7/10/2015.
 */
@Controller
@RequestMapping("/home/comments")
public class CommentAPI {
    @Resource
    CommentDao commentDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Comment> getAllArticles() {
        return commentDao.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    Boolean addIntoCollection(@RequestBody Comment comment) {
        this.commentDao.saveComment(comment);
        return true;
    }
}
