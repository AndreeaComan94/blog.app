package com.echo.blog.app.test;

import com.echo.blog.ApplicationConfig;
import com.echo.blog.model.Article;
import com.echo.blog.model.Author;
import com.echo.blog.repository.ArticleDao;
import com.echo.blog.repository.AuthorDao;
import com.echo.blog.util.IsbdnGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by UserA on 7/9/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class MongoArticleTest {

    @Resource
    ArticleDao articleDao;

    @Resource
    AuthorDao authorDao;


    @Test
    public void testSaveAuthor() {
        Author author = new Author();
        author.setName("Ion Creanga");
        author = authorDao.save(author);

        List<Author> actual = authorDao.findByName(author.getName());

        assertTrue(actual.contains(author));

        actual = authorDao.findByAttributes("name", author.getName());
        assertTrue(actual.contains(author));
    }

    @Test
    public void testSaveArticle() {
        Author author = authorDao.findAll().get(0);

        Article article = new Article();
        article.setContent("content");
        article.setTitle("title");
        article.setIsbdn(IsbdnGenerator.generate());

        if (author != null) {
            article.addAuthor(author);
        }

        article = articleDao.saveArticle(article);

        Article actual = articleDao.findById(article.getId());

        assertEquals(article.getTitle(), actual.getTitle());
    }

}

