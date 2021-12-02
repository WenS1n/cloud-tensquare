package cn.vesns.article.controller;

import cn.vesns.pojo.ResponseResult;
import cn.vesns.pojo.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult handler(Exception e) {
        System.out.println("处理异常");

        return new ResponseResult(false, StatusCode.ERROR, e.getMessage());
    }

}
