package com.cgy.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author GyuanYuan Cai
 * 2021/10/6
 * Description:
 *
 * 在lava中,对于异常的处理一般有两种方式:
 * 一种是当前方法捕获处理(try-catch) ,这种处理方式会造成业务代码和异常处理代码的耦合。
 * 另一种是自己不处理,而是抛给调用者处理(throws) ,调用者再抛给它的调用者,也就是一直向上抛。在这种方法的基础上,衍生出了SpringMVC的异常处理机制。
 * 系统的dao, service, controller出现都通过throws Exception向上抛出,最后由springmvc前端控制器交由异常处理器进行异常处理,如下图:
 *
 */

public class GlobalExceptionResolven implements HandlerExceptionResolver {

    // Exception e:实际地出的异常对象
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //具体的异常处理产生异常后,跳转到一个最终的异常页面
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", ex.getMessage());
        modelAndView.setViewName("error");
        return null;
    }
}