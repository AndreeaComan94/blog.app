package com.echo.blog.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by UserA on 7/7/2015.
 */
@Document
public class Article extends AbstractEntity{

    private String title;
    private String content;

    @Indexed(unique = true)
    private String isbdn;

    private List<String> authorsList = new ArrayList<String>();

    public Article() {
    }

    public Article(String title, String content, String isbdn, List<String> authorsList) {
        this.title = title;
        this.content = content;
        this.isbdn = isbdn;
        this.authorsList = authorsList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIsbdn() {
        return isbdn;
    }

    public void setIsbdn(String isbdn) {
        this.isbdn = isbdn;
    }

    public List<String> getAuthorsList() {
        return authorsList;
    }

    public void setAuthorsList(List<String> authorsList) {
        this.authorsList = authorsList;
    }

    public void addAuthor(Author author) {
        this.authorsList.add(author.getId());
    }
}