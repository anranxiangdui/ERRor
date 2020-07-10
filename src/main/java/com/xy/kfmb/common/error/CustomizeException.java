package com.xy.kfmb.common.error;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomizeException {

    @ExceptionHandler(Exception.class)
    public String Exception(Exception e) throws Exception {
        System.out.println("SpringMVC------>检测到全局异常");
        throw e;
    }

    @ExceptionHandler(RuntimeException.class)
    public String RuntimeException(RuntimeException e) throws RuntimeException {
        System.out.println("SpringMVC------>检测到全局异常");
        throw e;
    }
}