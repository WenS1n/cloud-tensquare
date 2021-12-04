package cn.vesns.user.service;/**
 * @version :JDK1.8
 * @date : 2021-12-05 0:07
 * @author : vip865047755@126.com
 * @File : UserService.java
 * @software: IntelliJ IDEA
 */

import cn.vesns.user.pojo.User;

/**
 * @author: vesns vip865047755@126.com
 * @Title: UserService
 * @ProjectName: SSM
 * @Description:
 * @date: 2021-12-05 0:07
 */
public interface UserService {
    User selectUserById(String userId);
}
