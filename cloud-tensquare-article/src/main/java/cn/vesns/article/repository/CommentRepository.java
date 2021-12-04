package cn.vesns.article.repository;/**
 * @version :JDK1.8
 * @date : 2021-12-04 15:50
 * @author : vip865047755@126.com
 * @File : CommentRepository.java
 * @software: IntelliJ IDEA
 */

import cn.vesns.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author: vesns vip865047755@126.com
 * @Title: CommentRepository
 * @ProjectName: cloud-tensquare
 * @Description:
 * @date: 2021-12-04 15:50
 * MongoRepository<操作实体,实体主键类型>
 */
public interface CommentRepository extends MongoRepository<Comment,String> {
}
