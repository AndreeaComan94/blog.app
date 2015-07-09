package com.echo.blog.model;

import org.springframework.data.mongodb.core.mapping.Document;



/**
 * Created by UserA on 7/7/2015.
 */
@Document
public class Author extends AbstractEntity{
    private String name;
    private String registerNumber;

    public Author(){}

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }
}
