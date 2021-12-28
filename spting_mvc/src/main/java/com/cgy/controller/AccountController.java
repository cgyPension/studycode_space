package com.cgy.controller;

import com.cgy.bean.Account;
import com.cgy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GyuanYuan Cai
 * 2021/10/28
 * Description:
 *
 *  spring和springMVC其实根本就不用整合,本来就是一家。但是我们需要做到spring和web容器整合,让web容器启动的时候自动加载spring配置文件, web容器销毁的时候spring的ioc容器也销毁。
 *  ,可以使用spring-web包中的ContextLoaderListener监听器,可以监听servletContext容器的创建和销毁,来同时创建或销毁1OC容器。
 *
 *
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    //实现查询所有账户
    @RequestMapping("/selectAll")
    public String selectAll(Model model){

        // 调用service 返回的结果
        List<Account> list = accountService.selectAll();

        //把封装好的list存到model中
        model.addAttribute("list",list);
        return "list"; // 信息会存到webapp 文件下的 list.jsp 这里还没配 要遍历 list 里面的信息
    }

    @RequestMapping("/save")
     public String save(Account account){
         accountService.save(account);
         //跳转到selectAll方法从新查询-次数据库进行数据的遍历展示
        return "redirect:/account/save";
     }

    @RequestMapping("/selectId")
    public String selectId(Integer id,Model model){
        Account account = accountService.selectId(id);
        //跳转到selectAll方法从新查询-次数据库进行数据的遍历展示
        // 存到model中
        model.addAttribute("account",account);

        // 视图跳转
        return "update";
    }

    // 更新账户
    @RequestMapping("/update")
    public String update(Account account){
        accountService.update(account);

        // 视图跳转
        return "redirect:/account/selectAll";
    }

    // 批量删除
}