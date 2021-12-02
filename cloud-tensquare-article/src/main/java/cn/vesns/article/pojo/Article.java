package cn.vesns.article.pojo;/**
 * @version :JDK1.8
 * @date : 2021-12-03 0:58
 * @author : vip865047755@126.com
 * @File : Article.java
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
 * @Title: Article
 * @ProjectName: cloud-tensquare
 * @Description:
 * @date: 2021-12-03 0:58
 */
@TableName("tb_article")
@Data
@ToString
public class Article implements Serializable {
    @TableId(type = IdType.INPUT)
    private String id;//ID

    private String columnid;    //专栏ID
    private String userid;      //用户ID
    private String title;       //标题
    private String content;     //文章正文
    private String image;       //文章封面
    private Date createtime;    //发表日期
    private Date updatetime;    //修改日期
    private String ispublic;    //是否公开
    private String istop;       //是否置顶
    private Integer visits;     //浏览量
    private Integer thumbup;    //点赞数
    private Integer comment;    //评论数
    private String state;       //审核状态
    private String channelid;   //所属频道
    private String url;         //URL
    private String type;        //类型

}
