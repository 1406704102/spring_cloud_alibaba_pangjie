package com.ppj.exception;

import cn.dev33.satoken.exception.SaTokenException;
import cn.dev33.satoken.util.SaResult;
import com.result.Result;
import com.result.ResultUtil;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class PJExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result<Object> test(Exception e) {
        System.out.println(e);
        return ResultUtil.error(e.getMessage());
    }

    @ExceptionHandler(SaTokenException.class)
    public Result<Object> handlerSaTokenException(SaTokenException e) {

        // 根据不同异常细分状态码返回不同的提示
        if (e.getCode() == 30001) {
            return ResultUtil.error("redirect 重定向 url 是一个无效地址");
        }
        if (e.getCode() == 30002) {
            return ResultUtil.error("redirect 重定向 url 不在 allowUrl 允许的范围内");
        }
        if (e.getCode() == 30004) {
            return ResultUtil.error("提供的 ticket 是无效的");
        }
        // 更多 code 码判断 ...

        // 默认的提示
        return ResultUtil.error("服务器繁忙，请稍后重试...");
    }

    //处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Result BindExceptionHandler(BindException e) {
//        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        return ResultUtil.error(e.getMessage());
    }

    //处理请求参数格式错误 @RequestParam上validate失败后抛出的异常是javax.validation.ConstraintViolationException
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Result ConstraintViolationExceptionHandler(ConstraintViolationException e) {
//        String message = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining());
        return ResultUtil.error(e.getMessage());
    }

    //处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常。
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
//        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        return ResultUtil.error(e.getMessage());
    }
}
