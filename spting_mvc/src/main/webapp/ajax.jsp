<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/10/5
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax异步交互</title>
</head>
<body>
    <%-- 引入jquery.js --%>
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>

    <button id="btn1">ajax异步交互</button>
    <script>
        $("#btn1").click(function (){
            let url = '${pageContext.request.contextPath}/user/ajaxRequest';
            let data = '[{"id":1,"username":"张三"},{"id":2,"username":"李四"}]';

            $.ajax({
                type:'POST',
                url:url,
                data:data,
                contentType:'application/json;charset=utf-8',
                success:function (resp){
                    alert(JSON.stringify(resp));
                }
            })
        })
    </script>
</body>
</html>
