package com.echo.blog.app.test;

import com.echo.blog.ApplicationConfig;
import com.echo.blog.model.Author;
import com.echo.blog.model.Comment;
import com.echo.blog.repository.AuthorDao;
import com.echo.blog.repository.CommentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by UserA on 7/10/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class MongoCommentTest {

    @Resource
    CommentDao commentDao;

    @Test
    public void saveComment(){

        Comment comment = new Comment();
        comment.setPersonCom("Marius");
        comment.setContent("Ce vreme frumoasa23");

        comment = commentDao.saveComment(comment);
        Comment comm= commentDao.findById(comment.getId());

        assertEquals(comment.getContent(), comm.getContent());
    }

   /* @Test
    public List<Comment> findByAuthor(Long Author){
        Comment commentrsp = commentDao.findByAuthor(comment.setPersonCom("Adrian"));
        if(comment.equals(comment.getPersonCom())

    }*/
}
