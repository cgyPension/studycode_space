package com.cgy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author GyuanYuan Cai
 * 2021/10/6
 * Description:
 */
@Controller
public class TargetController {
    @RequestMapping("/target")
    public String targetMethod(){
        System.out.println("目标方法执行了....");
        return "success";
    }

}