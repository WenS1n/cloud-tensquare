package cn.vesns.user;/**
 * @version :JDK1.8
 * @date : 2021-12-05 0:02
 * @author : vip865047755@126.com
 * @File : pojo.java
 * @software: IntelliJ IDEA
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: vesns vip865047755@126.com
 * @Title: pojo
 * @ProjectName: SSM
 * @Description:
 * @date: 2021-12-05 0:02
 */
@SpringBootApplication
@MapperScan("cn.vesns.user.mapper")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
