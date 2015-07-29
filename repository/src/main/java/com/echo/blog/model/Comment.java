package com.echo.blog.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.TimeZone;

/**
 * Created by UserA on 7/7/2015.
 */
@Document
public class Comment extends AbstractEntity{
    private String personCom;
    private String content;

    public Comment(){}

    public Comment(String personCom, String content) {
        this.personCom = personCom;
        this.content = content;
    }

    public String getPersonCom() {
        return personCom;
    }

    public void setPersonCom(String personCom) {
        this.personCom = personCom;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
