package cn.vesns.user.service.impl;/**
 * @version :JDK1.8
 * @date : 2021-12-05 0:08
 * @author : vip865047755@126.com
 * @File : UserServiceImpl.java
 * @software: IntelliJ IDEA
 */

import cn.vesns.user.pojo.User;
import cn.vesns.user.mapper.UserMapper;
import cn.vesns.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: vesns vip865047755@126.com
 * @Title: UserServiceImpl
 * @ProjectName: SSM
 * @Description:
 * @date: 2021-12-05 0:08
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    UserMapper userMapper;

    @Override
    public User selectUserById(String userId) {
        return userMapper.selectById(userId);
    }
}
