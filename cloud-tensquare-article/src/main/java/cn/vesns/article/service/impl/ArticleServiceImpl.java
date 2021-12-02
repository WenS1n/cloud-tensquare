package cn.vesns.article.service.impl;/**
 * @version :JDK1.8
 * @date : 2021-12-03 1:04
 * @author : vip865047755@126.com
 * @File : ArticleServiceimpl.java
 * @software: IntelliJ IDEA
 */

import cn.vesns.article.mapper.ArticleMapper;
import cn.vesns.article.pojo.Article;
import cn.vesns.article.service.ArticleService;
import cn.vesns.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: vesns vip865047755@126.com
 * @Title: ArticleServiceimpl
 * @ProjectName: cloud-tensquare
 * @Description:
 * @date: 2021-12-03 1:04
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired(required = false)
    ArticleMapper articleMapper;

    @Autowired(required = false)
    IdWorker idWorker;

    @Override
    public List<Article> findAll() {
        return articleMapper.selectList(null);
    }

    @Override
    public Article findById(String articleId) {
        return articleMapper.selectById(articleId);
    }

    @Override
    public void save(Article article) {
        String id = idWorker.nextId() + "";
        article.setId(id);
        article.setVisits(0);
        article.setThumbup(0);
        article.setComment(0);
        articleMapper.insert(article);

    }
}
