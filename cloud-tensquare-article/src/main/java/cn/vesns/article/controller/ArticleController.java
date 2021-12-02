package cn.vesns.article.controller;/**
 * @version :JDK1.8
 * @date : 2021-12-03 1:04
 * @author : vip865047755@126.com
 * @File : ArticleController.java
 * @software: IntelliJ IDEA
 */

import cn.vesns.article.pojo.Article;
import cn.vesns.article.service.ArticleService;
import cn.vesns.pojo.ResponseResult;
import cn.vesns.pojo.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: vesns vip865047755@126.com
 * @Title: ArticleController
 * @ProjectName: cloud-tensquare
 * @Description:
 * @date: 2021-12-03 1:04
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired(required = false)
    ArticleService articleService;

    @GetMapping()
    public ResponseResult findFindAll() {
        List<Article> list = articleService.findAll();
        return new ResponseResult(true, StatusCode.OK,"查询成功",list);
    }

    @GetMapping("/{articleId}")
    public ResponseResult findById(@PathVariable String articleId) {
        Article article = articleService.findById(articleId);
        return new ResponseResult(true,StatusCode.OK,"查询成功",article);
    }

    @PostMapping()
    public ResponseResult save(@RequestBody Article article) {
        articleService.save(article);
        return new ResponseResult(true,StatusCode.OK,"新增成功");
    }
}
