<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/10/5
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--${pageContext.request.contextPath}动态的来获取当前的项目路径--%>
        <a href="${pageContext.request.contextPath}/user/simpleParam?id=1&username=小陈">
            基本类型参数
    </a>

    <%-- form表单 该表单的请求方法为post类型--%>
    <form action="${pageContext.request.contextPath}/user/pojoParam" method="post">
        编号：<input type="text" name="id"><br>
        用户名：<input type="text" name="name"><br>
        <input type="submit" value="对象类型参数">
    </form>

    <%-- 获取演示数组请求参数 --%>
    <form action="${pageContext.request.contextPath}/user/arrayParam" method="post">
        编号：<input type="checkbox" name="id" value="1">1<br>
        编号：<input type="checkbox" name="id" value="2">2<br>
        编号：<input type="checkbox" name="id" value="3">3<br>
        编号：<input type="checkbox" name="id" value="4">4<br>
        <input type="submit" value="数组类型参数">
    </form>

    <%-- 获取集合请求参数 --%>
    <form action="${pageContext.request.contextPath}/user/queryParam" method="post">
        搜索关键字：<input type="text" name="keyword"><br>

        User对象：<input type="text" name="user.id" placeholder="编号"><br>
                <input type="text" name="user.name" placeholder="姓名"><br>

        list集合:
        第一个元素：
        <input type="text" name="userList[0].id" placeholder="编号"><br>
        <input type="text" name="userList[0].name" placeholder="姓名"><br>

        第二个元素：
        <input type="text" name="userList[1].id" placeholder="编号"><br>
        <input type="text" name="userList[1].name" placeholder="姓名"><br>

        map集合：
        第一个元素：
        <input type="text" name="userMap['u1'].id" placeholder="编号">
        <input type="text" name="userMap['u1'].name" placeholder="姓名">

        第二个元素：
        <input type="text" name="userMap['u2'].id" placeholder="编号">
        <input type="text" name="userMap['u2'].name" placeholder="姓名">

        <input type="submit" value="复杂类型参数">
    </form>

    <%--演示自定义类型转换器:错误的产生  2012-12-12
      正确的格式：2012/12/12
    --%>
    <form action="${pageContext.request.contextPath}/user/converterParam" method="post">
        生日：<input type="text" name="birthday"><br>
        <input type="submit" value="自定义类型转换器">
    </form>

    <%--演示@RequestParam--%>
    <a href=${pageContext.request.contextPath}/user/findByParam?pageNo=2" >
        分页查询
    </a>

    <%-- 引入jquery.js --%>
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"/>

</body>
</html>
