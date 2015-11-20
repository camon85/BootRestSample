package com.camon.boot.rest.sample.service;

import com.camon.boot.rest.sample.domain.Article;
import com.camon.boot.rest.sample.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    public List<Article> findAll(String content) {
        List<Article> articles;

        if (StringUtils.isEmpty(content)) {
            articles = repository.findAll();
        } else {
            articles = repository.findByContentContainingIgnoreCase(content);
        }

        return articles;
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

    public Article modify(Long id, Article article) {
        Article oldArticle = findById(id);
        oldArticle.setContent(article.getContent());
        oldArticle.setUpdated(new Date());
        return repository.save(oldArticle);
    }

    public void remove(Long id) {
        repository.delete(id);
    }
}
