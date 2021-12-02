package cn.vesns.article.service;

import cn.vesns.article.pojo.Article;

import java.util.List;

/**
 * @author : vip865047755@126.com
 * @version :JDK1.8
 * @date : 2021-12-03 1:03
 * @File : ArticleService.java
 * @software: IntelliJ IDEA
 */
public interface ArticleService {
    List<Article> findAll();

    Article findById(String articleId);

    void save(Article article);
}
