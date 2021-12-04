package cn.vesns.user.pojo;/**
 * @version :JDK1.8
 * @date : 2021-12-05 0:06
 * @author : vip865047755@126.com
 * @File : User.java
 * @software: IntelliJ IDEA
 */

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: vesns vip865047755@126.com
 * @Title: User
 * @ProjectName: SSM
 * @Description:
 * @date: 2021-12-05 0:06
 */
@TableName("tb_user")
@ToString
@Data
public class User implements Serializable {
    @TableId(type = IdType.INPUT)
    private String id;

    private String mobile;
    private String password;
    private String nickname;
    private String sex;
    private Date birthday;
    private String avatar;
    private String email;
    private Date regdate;
    private Date updatedate;
    private Date lastdate;
    private Long online;
    private String interest;
    private String personality;
    private Integer fanscount;
    private Integer followcount;

}
