package cn.vesns.article.service;/**
 * @version :JDK1.8
 * @date : 2021-12-04 15:52
 * @author : vip865047755@126.com
 * @File : CommentService.java
 * @software: IntelliJ IDEA
 */

import cn.vesns.article.pojo.Comment;

import java.util.List;

/**
 * @author: vesns vip865047755@126.com
 * @Title: CommentService
 * @ProjectName: cloud-tensquare
 * @Description:
 * @date: 2021-12-04 15:52
 */
public interface CommentService {
    List<Comment> findAll();

    Comment findById(String commentId);

    void save(Comment comment);

    void updateById(Comment comment);

    void deleteById(String commentId);

    List<Comment> findByArticleId(String articleId);

    void thumbup(String commentId);

    void unthumbup(String commentId);
}
