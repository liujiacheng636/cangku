<%--
  Created by IntelliJ IDEA.
  User: 86183
  Date: 2021/11/26
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@page pageEncoding="UTF-8" isErrorPage="false" contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <title>hello</title>
</head>
<body>

<h1>hello,${sessionScope.user.username}}</h1>
<div>
    <p>${CRUDmsg}</p>
    <a href="${pageContext.request.contextPath}/user/welcome">回到欢迎页面</a>
</div>

<div>
    <form action="${pageContext.request.contextPath}/param1/upload.do" enctype="multipart/form-data" method="post">
        上传头像<input type="file" name="image">
               <input type="submit" value="上传"><br>
    </form>
</div>

</body>
</html>
