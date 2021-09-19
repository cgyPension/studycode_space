package com.javaweb.webbackend01;

/**
 * @author GyuanYuan Cai
 * 2021/9/19
 * Description: MVC模式及三层架构
 *
 * JSP,简化了servlet开发;如果过度使用SP,在ISP页面中写了大量的java代码和html标签,造成难于维护,难于分工协作的场景。
 * 再后来为了弥补过度使用jsp的问题,我们使用servlet-jsp这套组合拳,利于分工协作。.
 *
 *
 * MVC设计模式: Model-View-Controller简写.
 * MVC是软件工程中的一种软件架构模式,它是一种分离业务逻辑与显示界面的设计方法。
 * 简单来说:前辈们总结的一套设计经验,适合在各种软件开发领域,目的:高内聚,低耦合
 *
 * M: model (模型) JavaBean (1,处理业务逻辑、2.封装实体):   【与数据库交互】
 * V: view (视图) Jsp (展示数据；动、静资源)
 * C: controller (控制器) Servlet (1,接收请求、2.调用模型、3.转发视图)
 *
 * 优点：降低耦合性,方便維护和拓展,利于分工协作
 * 缺点：使得项目架构变得复杂,对开发人员要求高
 *
 *
 * 三层架构（MVC升级，写代码一般从dao层往上写）
 * 在模型层上再分：
 *      业务逻辑层：处理业务逻辑
 *      数据访问层（持久层）：与数据库进行交互，实现基本的增删改查
 * 表现层：controller(控制器) + view (视图)
 *
 * 表示(现)层:又称为web层,与浏览器进行数据交互(控制器和视图)
 * 业务逻辑层:又称为service层,处理业务数据(if判断, for循环) 将多个dao的方法组合到一起,实现某个具体的功能
 * 数据访问(持久)层:又称为dao层,与数据库进行交互（基本的增删改查）的(每一条(行)记录与javaBean实体对应)
 *
 * find():查询
 * insert():添加
 * update():更新
 * delelet():删除
 *
 * 包目录结构
 * com.lagou基本包公司域名倒写
 * com.lagou.dao持久层
 * com.lagou.service业务层
 * com.lagou.web表示层
 * com.lagou.domain实体(JavaBean)
 * com.lagou.util工具
 *
 */

public class $26_MVC {


}