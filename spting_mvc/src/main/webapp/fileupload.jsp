<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/10/6
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>

        <%--
        编写一个满足文件上传三要素的表单
        1·表单的提交方式必须是post
        2. 老enctype 属t 修tmptipart/form-data
        3.表单中必须要有文件上传项
        --%>
        <form action="${pageContext.request.contextPath}/fileupload" method="post" enctype="multipart/form-data">
            名称：<input type="text" name="username"><br>
            文件：<input type="file" name="filePic"><br>
            名称：<input type="submit" name="表单文件上传"><br>
        </form>

        <%-- 实现多文件上传 --%>
        <form action="${pageContext.request.contextPath}/fileupload" method="post" enctype="multipart/form-data">
            名称：<input type="text" name="username"><br>
            文件1：<input type="file" name="filePic"><br>
            文件2：<input type="file" name="filePic"><br>
            名称：<input type="submit" name="多文件上传"><br>
        </form>

</body>
</html>
