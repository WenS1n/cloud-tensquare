package cn.vesns;/**
 * @version :JDK1.8
 * @date : 2021-12-03 0:31
 * @author : vip865047755@126.com
 * @File : CloudArticleApplication.java
 * @software: IntelliJ IDEA
 */

import cn.vesns.util.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author: vesns vip865047755@126.com
 * @Title: CloudArticleApplication
 * @ProjectName: cloud-tensquare
 * @Description:
 * @date: 2021-12-03 0:31
 */
@SpringBootApplication
//@MapperScan("cn.vesns.article.mapper")
public class CloudArticleApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudArticleApplication.class,args);
    }

    @Bean
    public IdWorker createIdWorker() {
        return new IdWorker(1, 1);
    }
}
