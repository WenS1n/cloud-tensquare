package cn.vesns.pojo;/**
 * @version :JDK1.8
 * @date : 2021-12-03 0:18
 * @author : vip865047755@126.com
 * @File : StatusCode.java
 * @software: IntelliJ IDEA
 */

/**
 * @author: vesns vip865047755@126.com
 * @Title: StatusCode
 * @ProjectName: cloud-tensquare
 * @Description:
 * @date: 2021-12-03 0:18
 */
public class StatusCode {
    /**
     * 成功
     */
    public static final int OK=20000;
    /**
     * 失败
     */
    public static final int ERROR =20001;
    /**
     * 用户名或密码错误
     */
    public static final int LOGINERROR =20002;
    /**
     * 权限不足
     */
    public static final int ACCESSERROR =20003;
    /**
     *     远程调用失败
     */
    public static final int REMOTEERROR =20004;

    /**
     * 重复操作
     */
    public static final int REPERROR =20005;

}
