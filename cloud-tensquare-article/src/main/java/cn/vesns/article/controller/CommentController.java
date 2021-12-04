package cn.vesns.article.controller;/**
 * @version :JDK1.8
 * @date : 2021-12-04 15:53
 * @author : vip865047755@126.com
 * @File : CommentController.java
 * @software: IntelliJ IDEA
 */

import cn.vesns.article.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: vesns vip865047755@126.com
 * @Title: CommentController
 * @ProjectName: cloud-tensquare
 * @Description:
 * @date: 2021-12-04 15:53
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired(required = false)
    private CommentService commentService;


}
