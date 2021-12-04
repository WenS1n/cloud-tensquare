package cn.vesns.article.service.impl;/**
 * @version :JDK1.8
 * @date : 2021-12-04 15:52
 * @author : vip865047755@126.com
 * @File : CommentServiceImpl.java
 * @software: IntelliJ IDEA
 */

import cn.vesns.article.pojo.Comment;
import cn.vesns.article.repository.CommentRepository;
import cn.vesns.article.service.CommentService;
import cn.vesns.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author: vesns vip865047755@126.com
 * @Title: CommentServiceImpl
 * @ProjectName: cloud-tensquare
 * @Description:
 * @date: 2021-12-04 15:52
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired(required = false)
    private CommentRepository commentRepository;

    @Autowired(required = false)
    private IdWorker idWorker;

    @Autowired(required = false)
    private MongoTemplate mongoTemplate;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(String commentId) {
        Optional<Comment> optional = commentRepository.findById(commentId);
        return optional.orElse(null);
    }

    @Override
    public void save(Comment comment) {
        String id = idWorker.nextId() + "";
//        comment.setc_id(id);
//        comment.set_id();
        comment.set_id(id);
        comment.setThumbup(0);
        comment.setPublishdate(new Date());
        commentRepository.save(comment);

    }

    @Override
    public void updateById(Comment comment) {
        // 如果主键存在则修改，不存在则新增
        commentRepository.save(comment);
    }

    @Override
    public void deleteById(String commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public List<Comment> findByArticleId(String articleId) {
        List<Comment> list = commentRepository.findByArticleid(articleId);
        return list;
    }

    /**
     * 点赞
     * @param commentId
     */
    @Override
    public void thumbup(String commentId) {
        // 根据评论id查询评论数据

        // 此处线程不安全，相当于i++模式！！
//        Comment comment = commentRepository.findById(commentId).get();
//        comment.setThumbup(comment.getThumbup() + 1);
//        commentRepository.save(comment);

        //点赞功能优化
        //封装修改的条件
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(commentId));

        //封装修改的数值
        Update update = new Update();
        //使用inc列值增长
        update.inc("thumbup", 1);

        //直接修改数据
        //第一个参数是修改的条件
        //第二个参数是修改的数值
        //第三个参数是MongoDB的集合名称
        mongoTemplate.updateFirst(query, update, "comment");
    }

    @Override
    public void unthumbup(String commentId) {
        //封装修改的条件
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(commentId));

        //封装修改的数值
        Update update = new Update();
        //使用inc列值增长
        update.inc("thumbup", -1);

        //直接修改数据
        //第一个参数是修改的条件
        //第二个参数是修改的数值
        //第三个参数是MongoDB的集合名称
        mongoTemplate.updateFirst(query, update, "comment");
    }
}
