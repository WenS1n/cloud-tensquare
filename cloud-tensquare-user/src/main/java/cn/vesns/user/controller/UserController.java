package cn.vesns.user.controller;/**
 * @version :JDK1.8
 * @date : 2021-12-05 0:12
 * @author : vip865047755@126.com
 * @File : UserController.java
 * @software: IntelliJ IDEA
 */

import cn.vesns.pojo.ResponseResult;
import cn.vesns.pojo.StatusCode;
import cn.vesns.user.pojo.User;
import cn.vesns.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: vesns vip865047755@126.com
 * @Title: UserController
 * @ProjectName: SSM
 * @Description:
 * @date: 2021-12-05 0:12
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired(required = false)
    private UserService userService;

    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    public ResponseResult selectById(@PathVariable String userId) {
        User user = userService.selectUserById(userId);
        return new ResponseResult(true, StatusCode.OK,"查询成功",user);

    }

}
