package com.echo.blog.repository;

import com.echo.blog.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by UserA on 7/8/2015.
 */
public interface  AuthorDao extends MongoRepository<Author, String> {

    List<Author> findByName(String name);

    @Query("{ ?0 : ?1 }")
    List<Author> findByAttributes(String key, String value);
}
