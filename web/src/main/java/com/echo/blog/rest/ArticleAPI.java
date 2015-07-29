package com.echo.blog.rest;

import com.echo.blog.model.Comment;
import com.echo.blog.repository.ArticleDao;
import com.echo.blog.model.Article;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by mcsere on 7/9/2015.
 */
@Controller
@RequestMapping("/home/articles")
public class ArticleAPI {

    @Resource
    ArticleDao articleDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Article> getAllArticles() {
        return articleDao.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    Boolean addIntoCollection(@RequestBody Article article) {
        this.articleDao.saveArticle(article);
        return true;
    }

    @RequestMapping(value="", method = RequestMethod.DELETE)
    public
    @ResponseBody
    void deleteIntoCollection(@PathVariable String id){
        this.articleDao.deleteArticle(id);
    }

    @RequestMapping(value = "/{id}/comments", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Comment> getAllComments(@PathVariable String id) {
        return articleDao.findById(id).getComments();
    }


    @RequestMapping(value = "/{id}/comments", method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    Boolean addIntoCollection(@PathVariable String id,@RequestBody Comment comment) {
        Article article = articleDao.findById(id);
        article.getComments().add(comment);
        articleDao.saveArticle(article);
        return true;
    }
}
