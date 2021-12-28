package com.cgy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author GyuanYuan Cai
 * 2021/10/5
 * Description:
 *
 * @PathVariable用来接收RESTful风格请求地址中占位符的值
 *
 * @RestController
 * RESTful风格多用于前后端分离项目开发,前端通过ajax与服务器进行异步交互,我们处理器通常返回的是json数据
 * 所以使用@RestController来替代@Controller和@ResponseBody两个注解。
 *
 *
 * 文件上传三要素
 * 表单项type="file"
 * 表单的提交方式method="POST"表单的enctype属性是多部分
 * 表单形式enctype="multipart/form-data"
 */

//@Controller
@RestController // 组合注解:组合@Controller +@ResponseBody
@RequestMapping("/restful")
public class RestfulController {
    /*
      根据d进行查询
      Localhost:8080/项目名/restful/user/2 + get请求方式

    * */
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    //@ResponseBody
    public String findById(@PathVariable Integer id){
        //调用service方法完成对id为2的这条记录的
        //查询findById方法中怎么才能获取restfu1编程风格中url里面占位符的值
        return "findById:"+id;
    }

    // 新增方法
    @PostMapping("/user") // 相当于@RequestMapping(value = "/user",method = RequestMethod.POST)
    public String post(){
        return "post";
    }

    // 更新方法
    @PostMapping("/user")
    public String put(){
        return "put";
    }

    // 删除方法
    @PostMapping("/user/{id}")
    public String put(@PathVariable Integer id){
        return "delete" + id;
    }
}