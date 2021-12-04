package cn.vesns.article.pojo;/**
 * @version :JDK1.8
 * @date : 2021-12-04 15:48
 * @author : vip865047755@126.com
 * @File : Comment.java
 * @software: IntelliJ IDEA
 */

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: vesns vip865047755@126.com
 * @Title: Comment
 * @ProjectName: cloud-tensquare
 * @Description:
 * @date: 2021-12-04 15:48
 */
@Data
@ToString
public class Comment implements Serializable {

    @Id
    private String _id;
    private String articleid;
    private String content;
    private String userid;
    private String parentid;
    private Date publishdate;
    private Integer thumbup;

}
