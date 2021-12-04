package cn.vesns.article.service.impl;/**
 * @version :JDK1.8
 * @date : 2021-12-04 15:52
 * @author : vip865047755@126.com
 * @File : CommentServiceImpl.java
 * @software: IntelliJ IDEA
 */

import cn.vesns.article.repository.CommentRepository;
import cn.vesns.article.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
