package com.cgy.controller;

import com.cgy.bean.QueryVo;
import com.cgy.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author GyuanYuan Cai
 * 2021/10/5
 * Description:
 *
 * SprigMVC执行流程
 * 1·用户发送请求至前端控制器DispatcherServlet
 * 2. Dispatcher Servlet收到请求调用Handl erMapping处理器映射器。
 * 3,处理器映射器找到具体的处理器(可以根据xml配置、注解进行查找),生成处理器对象及处理器拦截器(如果有则生成)一并返回给DispatcherServlet
 * 4. Dispatcher Servlet调用Handl er Adapter处理器适配器
 * 5. HandlerAdapter经过适配调用具体的处理器(Controller,也叫后端控制器)。
 * 6. Controller执行完成返回Model Andview
 * 7. Handl erAdapter将controller执行结果Model Andview返回给Dispatcher Servlet
 * 8. Dispatcher Servlet将Model Andview传给viewReslover视图解析器。
 * 9. ViewReslover解析后返回具体view.
 * 10. DispatcherServlet根据view进行渲染视图(即将模型数据填充至视图中)。
 *
 *
 * SpringMVc组件解析
 * 1.前端控制器: DispatcherServlet用户请求到达前端控制器,它就相当于MVC模式中的C, DispatcherServlet是整个流程控制的中心,由它调用其它组件处理用户的请求, Dispatcher Servlet的存在降低了组件之间的耦合性。
 * 2.处理器映射器: HandlerMapping 负责根据用户请求找到Handler即理器, SpringMVC提供了不同的映射器实现不同的映射方式,例如:配置文件方式,实现接口方式,注解方式等。
 * 3.处理器适配器: HandlerAdapter通过Handler Adapter对处理器进行执行,这是适配器模式的应用,通过扩展适配器可以对更多类型的处理器进行执行
 * 4.处理器: Handler 【*开发者编写*它就是我们开发中要编写的具体业务控制器。由Dispatcher Servlet把用户请求转发到Handler。由Handler对具体的用户请求进行处理
 * 5·视图解析器: viewResolve 负责将处理结果生成view视图, view Resolver首先根据逻辑视图名解析成物理视图名,即具体的页面地址,再生成view视图对象,最后对view进行渲染将处理结果通过页面展示给用户。
 * 6.视图: view 【*开发者编写*springMvc框架提供了很多的view视图类型的支持,包括: jstIview, freemarkerview, pdfview等。最常用的视图就是jsp。一般情况下需要通过页面标签或页面模版技术将模型数据通过页面展示给用户,需要由程序员根据业务需求开发具体的页面。
 *
 * 客户端请求参数的格式是: name-valuename=value...
 * 服务器要获取请求的参数的时候要进行类型转换,有时还需要进行数据的封装
 * SpringMVC可以接收如下类型的参数:
 * 基本类型参数
 * 对象类型参数
 * 数组类型参数
 * 集合类型参数
 *
 * Controller中的业务方法的参数名称要与请求参数的name一致,参数值会自动映射匹配。并且能自动做类型转换;自动的类型转换是指从String向其他类型的转
 *
 * Gontroller中的业务方法参数的POJO属性名与请求参数的name-致,参数值会自动映射匹配。
 *
 * @RequestParam尝请求的参数name名称与Controller的业务方法参数名称不一致时,就需要通过@RequestParam注解显示的绑定
 *
 * SpringMVC响应方式介绍页面跳转
 * 1,返回字符串逻辑视图
 * 2. void原始ServletAPI
 * 3. ModelAndView
 * 返回数据
 * 1,直接返回字符串数据
 * 2.将对象或集合转为json返回(任务二演示)
 *
 *
 * 企业开发我们一般使用返回字符串逻辑视图实现页面的跳转,这种方式其实就是请求转发。,我们也可以写成: forward转发
 * 如果用了forward:则路径必须写成实际视图url,不能写逻辑视图。它相当于:
 *
 * ajax异步交互
 * Springmvc默认用Mappinglackson2HttpMessageConverter对json数据进行转换,需要加入jackson的包;同时使用<mvc: annotation-driven
 *
 * Restful是一种软件架构风格、设计风格,而不是标准
 * Restful风格的请求是使用"url+请求方式"表示一次请求目的的, HTTP协议里面四个表示操作方式的动词如下:
 * GET:读取(Read)
 * POST:新建(Create)
 * PUT:更新(Update)
 * DELETE:删除(Delete)
 *
 */
@Controller
@RequestMapping("/user") //一级访问目录
//@SessionAttributes的效果:多个请求之间共享数据
@SessionAttributes("username") //向request域中(model)中存入key为username时,会同步到session域中
public class UserConttroller {
    private Model model;

    //二级访问目录
    /*
    path:作用等同Fvalue，同样是设置方法的映射地址
    method：用来限定请求的方式RequestMethod.POST:只能以post的请求方式访问该访问,其他请求方式会报错
    params:用来限定请求参数的条件params={"accountName"}表示请求参数中必须有accountName
    */
    @RequestMapping(path="/quick",method= RequestMethod.POST,params = {"accountName"}) // 用于建立请求URL和处理请求方法之间的对应关系
    public String quick(){
        // 业务逻辑
        System.out.println("springmvc入门成功...");
        // 视图跳转
        //return "/WEB-INF/pages/success.jsp";
        return "success";
    }

    // 获取基本类型请求参数
    @RequestMapping("/simpleParam")
    public String simpleParam(Integer id,String name){
        System.out.println(id);
        System.out.println(name);
        return "success";
    }

    // 获取对象类型参数
    @RequestMapping("/pojoParam")
    public String pojoParam(User user){
        System.out.println(user);
        return "success";
    }

    // 获取数组类型参数
    @RequestMapping("/arrayParam")
    public String arrayParam(Integer[] ids){
        System.out.println(Arrays.toString(ids));
        return "success";
    }

    // 获取集合（复杂）类型参数
    @RequestMapping("/queryParam")
    public String queryParam(QueryVo queryVo){
        System.out.println(queryVo);
        return "success";
    }

    // 获取日期类型参数：（自定义类型转换器)
    @RequestMapping("/converterParam")
    public String converterParam(Date birthday){
        System.out.println(birthday);
        return "success";
    }

    // 演示@RequestParam
    // name:匹配页面传递参数的名称
    // defaultValue:设置参数的默认值
    // required：设置是否必须传递该参数,默认值为true,如果设置了默认值,值自动改为false
    @RequestMapping("/findByParam")
    public String findByParam(@RequestParam(name = "pageNo",defaultValue = "1",required = false) Integer pageNum, Integer pageSize){
        System.out.println(pageNum);
        System.out.println(pageSize);
        return "success";
    }

    //@RequestHeader 获取请求头中的信息
    @RequestMapping("/requestHead")
    public String requestHead(@RequestHeader("Cookie")String cookie){
        System.out.println(cookie);
        return "success";
    }

    // @CookieValue 获取cookie里的信息
    @RequestMapping("/cookieValue")
    public String cookieValue(@CookieValue("JSESSIONID") String jsessionId){
        System.out.println(jsessionId);
        return "success";
    }

    // 原始serlvetAPI的获取
    @RequestMapping("/servletApi")
    public String servletApi(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
        return "success";
    }

    // 通过原始servletAPI进行页面跳转
    @RequestMapping("/returnVoid")
    public String returnVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 直接返回数据
    /*    response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("小陈老师");*/


        //借助request对象完成请求转发
        request.getRequestDispatcher("/webapp/WEB-INF/pages/success.jsp").forward(request,response);
        //借助response对象完成重定向 两次请求WEB-INF:安全目录:不允许外部请求直接访问该目录资源,只可以进行服务器内部转发
        //response.sendRedirect(request.getContextPath()+"/webapp/WEB-INF/pages/success.jsp");
        response.sendRedirect(request.getContextPath()+"/index.jsp");
        return "success";
    }

    // 演示forward关键字进行请求转发
    @RequestMapping("/forward")
    public String forward(Model model){
        //还想在模型中设置一些值怎么做?
        model.addAttribute("username","小陈同学");
        //使用请求转发,既可以转发到jsp,也可以转发到其他的控制器方法
       // return "forward:/product/findAll";
        return "forward:/WEB-INF/pages/success.jsp";
    }

    // 演示Redirect关键字进行重定向  域范围:一次请求
    // 当写了redirect或者forward关键字,是不会再走视图解析器
    @RequestMapping("/redirect")
    public String redirect(Model model){
        this.model = model;
        model.addAttribute("username","小陈同学");
        return "redirect:/index.jsp";
    }

    // modelAndview进行页面跳转:方式一
    @RequestMapping("/returnModelAndView")
    public ModelAndView returnModelAndView(Model model){
        /*
        model:模型：作用封装存放数据
        view :视图:用来展示数据
        */
        ModelAndView modelAndView = new ModelAndView();
        // 设置模型数据
        modelAndView.addObject("username","modelAndview方式一");
        // 设置视图名称 视图解析器解析modelAndView拼接前缀和后后缀
        modelAndView.setViewName("success");
        return modelAndView;
    }

    // modeLAndView进行页面跳转：方式二
    @RequestMapping("/returnModelAndView2")
    public ModelAndView returnModelAndView2(ModelAndView modelAndView){
        /*
        model:模型：作用封装存放数据
        view :视图:用来展示数据
        */
        // 设置模型数据
        modelAndView.addObject("username","modelAndview方式二");
        // 设置视图名称 视图解析器解析modelAndView拼接前缀和后后缀
        modelAndView.setViewName("success");
        return modelAndView;
    }

    // 如果在多个请求之间共用数据,则可以在控制器类上标注一个@SessionAttributes,配置需要在session中存放的数据范围, Spring MVC将存放在model中对应的数据暂存到HttpSession 中。
    // @SessionAttributes的效果:多个请求之间共享数据
    @RequestMapping("/returnString")
    public String returnString(){
        return "success";

    }


    // ajax异步交互
    // @RequestBody该注解用于Controller的方法的形参声明,当使用ajax提交并指定contentType为json形式时,通过HttpMessageConverter接口转换为对应的POJO对象
    @RequestMapping("/ajaxRequsest")
    @ResponseBody // 该注解用于将Controller的方法返回的对象,通过HttpMessageConverter接口转换为指定格式的数据如: json,xml等,通过Response响应给客户端。
    public List<User> ajaxRequsest(@RequestBody List<User> userList){
        System.out.println(userList);
        return userList;
    }

}