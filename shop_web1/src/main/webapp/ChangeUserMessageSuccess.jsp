<%@ page pageEncoding="utf-8" %>
<%
    session.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML>

<html>
<head>
    <style type="text/css">
        body {
            background-image: url("${path }/image/2.jpg");
            background-repeat: repeat
        }
    </style>
</head>
<body>&nbsp;
<center>
    <img src="${path }/image/success.gif"/>
    <h1> 个人信息修改成功 </h1>
    <h1><a href="${path }/QueryProductAction">返回首页</a>&nbsp;&nbsp;
    </h1>
</center>
</body>
</html>