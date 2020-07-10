package com.xy.kfmb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomController {

    @GetMapping(value = "/success")
    public String hello() {
        System.out.println("Controller------>成功方法开始执行");
        return "成功";
    }

    @GetMapping(value = "/failure")
    public String a() {
        System.out.println("Controller------>异常方法开始执行");
        int a = 1 / 0;
        return "失败";
    }
}