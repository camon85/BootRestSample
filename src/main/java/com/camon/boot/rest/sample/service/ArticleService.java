package com.camon.boot.rest.sample.service;

import com.camon.boot.rest.sample.domain.Article;
import com.camon.boot.rest.sample.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by jooyong on 2015-11-20.
 */
@Service
@Transactional
public class ArticleService {

    @Autowired
    private ArticleRepository repository;

    public List<Article> findAll() {
        return repository.findAll();
    }

    public Article findById(Long id) {
        return repository.findOne(id);
    }

    public Article add(Article article) {
        Date now = new Date();
        article.setCreated(now);
        article.setUpdated(now);
        return repository.save(article);
    }

    public Article modify(Article article) {
        Date now = new Date();
        article.setUpdated(now);
        return repository.save(article);
    }

    public void remove(Long id) {
        repository.delete(id);
    }
}
