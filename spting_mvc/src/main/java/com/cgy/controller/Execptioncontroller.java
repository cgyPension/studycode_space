package com.cgy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author GyuanYuan Cai
 * 2021/10/6
 * Description:
 */
@Controller
public class Execptioncontroller {

    @RequestMapping("/textException")
    public String testException (){
       int i =1/0;
       return "success";
    }
}