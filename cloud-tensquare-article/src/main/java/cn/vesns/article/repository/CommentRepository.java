package cn.vesns.article.repository;/**
 * @version :JDK1.8
 * @date : 2021-12-04 15:50
 * @author : vip865047755@126.com
 * @File : CommentRepository.java
 * @software: IntelliJ IDEA
 */

import cn.vesns.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

/**
 * @author: vesns vip865047755@126.com
 * @Title: CommentRepository
 * @ProjectName: cloud-tensquare
 * @Description:
 * @date: 2021-12-04 15:50
 * MongoRepository<操作实体,实体主键类型>
 */
public interface CommentRepository extends MongoRepository<Comment,String> {

    //springframework.data.mongodb支持通过方法名进行查询定义的方式


    /**
     * 根据文章id查询评论
     * @param articleId
     * @return
     */

//    List<Comment> findByArticleid(String articleId);
    List<Comment> findByArticleid(String articleId);

    /**
     * 根据发布时间和点赞数查询
     * @param date
     * @param thumbup
     * @return
     */
//    List<Comment> findByPublishdataAndThumbup(Date date,Integer thumbup);


    /**
     * 根据用户id查询 并且根据发布时间倒序查询
     * @param usereId
     * @return
     */
//    List<Comment> findByUsereIdorderbyPublishdataDesc(String usereId);


}
