package com.javaweb.webbackend02;

/**
 * @author GyuanYuan Cai
 * 2021/9/19
 * Description:
 *
 * 一个项目管理工具
 * Maven基础
 * 1.Maven简介
 * 2.Maven安装和使用
 * 3.Maven生命周期和插件
 * 4.IDEA创建Maven工程
 *
 * Maven高级(SSM框架后讲解)
 * 5.Maven的依赖传递
 * 6.maven聚合工程(分模块) 
 *
 * JavaToWeb插件可以把maven项目转换为web项目
 * 发布web工程.
 * ①idea使用外置tomcati运行【重点】
 * ② idea使用maven内置tomcat插件【了解】
 *
 * <!--锁定jar包版本-->
 * <dependencyManagement>
 *  采用直接锁定版本的方法确定依赖ar包的版本,版本锁定后则不考虑依赖的声明顺序或依赖的路径,以锁定的版本为准添加到工程中,此方法在企业开发中经常但用。
 *  版本锁定的使用方式:
 *  第一步:在dependencyManagement标签中锁定依赖的版本
 *  第二步:在dependencies标签中声明需要导入的maven坐标
 *  ①在dependencyManagement标签中锁定依赖的版本
 *  ②在dependencies标签中声明需要导入的maven坐标
 *
 *  <properties>
 */

public class $01_Maven {


}