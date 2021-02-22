package com.cgy.docker_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GyuanYuan Cai
 * 2021/1/1
 * Description:
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello,docker";
    }

}