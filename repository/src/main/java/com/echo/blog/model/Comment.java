package com.echo.blog.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.TimeZone;

/**
 * Created by UserA on 7/7/2015.
 */
@Document
public class Comment extends AbstractEntity{
    private String author;
    private String description;
    private TimeZone time;

    public Comment( String author, String description, TimeZone time) {

        this.author = author;
        this.description = description;
        this.time = time;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TimeZone getTime() {
        return time;
    }

    public void setTime(TimeZone time) {
        this.time = time;
    }
}
