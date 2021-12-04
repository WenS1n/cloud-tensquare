package cn.vesns.article.controller;/**
 * @version :JDK1.8
 * @date : 2021-12-04 15:53
 * @author : vip865047755@126.com
 * @File : CommentController.java
 * @software: IntelliJ IDEA
 */

import cn.vesns.article.pojo.Comment;
import cn.vesns.article.service.CommentService;
import cn.vesns.pojo.ResponseResult;
import cn.vesns.pojo.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: vesns vip865047755@126.com
 * @Title: CommentController
 * @ProjectName: cloud-tensquare
 * @Description:
 * @date: 2021-12-04 15:53
 */
@RestController
@RequestMapping("/comment")
@CrossOrigin
public class CommentController {

    @Autowired(required = false)
    private CommentService commentService;

    @Autowired(required = false)
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "thumbup/{commentId}",method = RequestMethod.PUT)
    public ResponseResult thumbup(@PathVariable String commentId) {
        // 把用户信息存入redis中
        // 把每次点赞之前，先查询用户点赞信息
        // 如果没有点赞信息，用户才可以点赞
        // 如果又点赞信息，则不能重复点赞

        // 模拟用户id
        String userId = "123";
        // 查询用户点赞信息，根据用户id和评论id
        Object flag = redisTemplate.opsForValue().get("thumbup_" + userId + "_" + commentId);
        // 判断查询结果是否为空，为空表示用户没有点赞，可以点赞
        if (flag == null) {
            commentService.thumbup(commentId);
            redisTemplate.opsForValue().set("thumbup_" + userId + "_" + commentId,1);
            return new ResponseResult(true,StatusCode.OK,"点赞成功");
            // 点赞成功，保存点赞信息
        } else {
            commentService.unthumbup(commentId);
            redisTemplate.delete("thumbup_" + userId + "_" + commentId);
            return new ResponseResult(true,StatusCode.OK,"取消点赞成功");
        }
        // 如果不为空，则不能点赞
//        return new ResponseResult(false,StatusCode.REPERROR,"不能重复点赞");



    }

    @RequestMapping(value = "/article/{articleId}",method = RequestMethod.GET)
    public ResponseResult findArticleById(@PathVariable String articleId) {
        List<Comment> list = commentService.findByArticleId(articleId);
        return new ResponseResult(true,StatusCode.OK,"查询成功",list);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseResult findAll() {
        List<Comment> list = commentService.findAll();
        return new ResponseResult(true, StatusCode.OK,"查询成功",list);
    }

    @RequestMapping(value = "{commentId}",method = RequestMethod.GET)
    public ResponseResult findById(@PathVariable String commentId) {
        Comment comment = commentService.findById(commentId);
        return new ResponseResult(true, StatusCode.OK, "查询成功",comment);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseResult save(@RequestBody Comment comment) {
        commentService.save(comment);
        return new ResponseResult(true, StatusCode.OK, "新增成功");
    }

    @RequestMapping(value = "{commentId}", method = RequestMethod.PUT)
    public ResponseResult update(@PathVariable String commentId, @RequestBody Comment comment) {
        comment.set_id(commentId);
        commentService.updateById(comment);
        return new ResponseResult(true, StatusCode.OK, "修改成功");
    }

    @RequestMapping(value = "{commentId}",method = RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable String commentId) {
        commentService.deleteById(commentId);
        return new ResponseResult(true, StatusCode.OK, "删除成功");
    }
}
