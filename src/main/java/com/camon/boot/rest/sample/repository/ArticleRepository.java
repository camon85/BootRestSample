package com.camon.boot.rest.sample.repository;

import com.camon.boot.rest.sample.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jooyong on 2015-11-20.
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByContentContainingIgnoreCase(String content);
}
