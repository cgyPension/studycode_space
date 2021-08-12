package com.javaweb.webbackend01;

/**
 * @author GyuanYuan Cai
 * 2021/5/30
 * Description:
 *
 * C/S架构
 * Client/Server客户端/服务器 访问服务器资源必须安装客户端软件
 * 例如:QQ,绝地求生,LOL
 * 优点:用户体验好
 * 缺点:需要对客户端及服务器代码都需要进行开发,部署和维护
 *
 * B/S架构 Browser/ Server浏览器/服务器 b/s果构称为是一种特殊的/s架构(安装个测览器）
 * 特点:访问服务器置源,是不需要安装专门的客户端软件,而是直按通过测览器进行服务器资源的访问
 * 优点:开发,部署维护简单
 * 缺点:用户体验稍差
 *
 * 资源:计算机中数据文件
 * 静态资源
 * 对于同一个页面不同用户看到的内容是一样的
 * 例妙如:体育新闻、网站门户等,常见后缀:,html、img,ccs
 * 动态资源
 * 用对于同一个页面,不司用户看到的内容可能不一样
 * o例如:购物车、我的订单等,常见后缀:,jsp,axpx、,php
 *
 * 1.2Web服务器作用
 * ・开发者通过web服务器可以把本地=资源==发布到互联网 用户就可以通过浏览询问这些资源
 * 浏览器只能识别静态资源 tomact可以进行转换
 *
 *
 * URL完整格式:协议//城名:端口号/资源位置?参数=值
 * 协议:http https ftp等等 TCP UDP
 * 城名:域名/p地址,都可以访问到web资源
 * 默认端口是80端口 可以不写
 *
 * tomact目录结构
 * webapps 发布自己的网站目录
 * work运行时所生成的一些文件
 * runnng.txt 党群啊tomcat的版本信息
 * bin/startup.bat 是启动脚本
 * shutdown.bat 关闭脚本
 * 或者在tomcat口内部ctrl+c二次 表示正常关闭
 *
 * 项目发布的三种方式
 * 一、webapps目录发布（仅了解） 直接放置在目录下 localhost:8080/myapp/index.html
 * 二、server.xml部署 （仅了解）conf、server.xml
 * 三、独立xml部署 conf/Catalina/localhost 创建xxx.xml(文件名对应虚拟路径)
 *  <Context docbase="D: Wwebapppsmyapd'/>
 */

public class $01_Tomact {
    public static void main(String[] args) {
    /*

    */


    }

}