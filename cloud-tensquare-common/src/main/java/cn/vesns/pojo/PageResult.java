package cn.vesns.pojo;/**
 * @version :JDK1.8
 * @date : 2021-12-03 0:14
 * @author : vip865047755@126.com
 * @File : PageResult.java
 * @software: IntelliJ IDEA
 */

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;

/**
 * @author: vesns vip865047755@126.com
 * @Title: PageResult
 * @ProjectName: cloud-tensquare
 * @Description:
 * @date: 2021-12-03 0:14
 */
public class PageResult<T> {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long total;
    private List<T> rows;

    public PageResult() {
    }



}
