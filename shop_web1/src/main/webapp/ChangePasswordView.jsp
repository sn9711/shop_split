<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

        span {
            font-size: 30px;
            color: red;
            font-weight: bolder;
            margin-left: 200px
        }

        .f {
            width: 150px;
            height: 70px
        }

        .d {
            text-align: center;
            word-spacing: 20px;
            width: 70%
        }

        img {
            border: none
        }

        td.TableBody1 {
            background-color: #FFFFFF;
            line-height: normal;
        }

        td.TableBody2 {
            background-color: #E4F3FF;
            line-height: normal;
        }

        .tableBorder1 {
            width: 97%;
            border: 1px;
            background-color: #AFB2C4;
        }
    </style>
</head>
<body>&nbsp;

<!-- 动态包含 -->
<jsp:include page="Include.jsp"></jsp:include>

<c:if test="${sessionScope.use != null }">
    <form method="post" action="${path }/l/ChangePasswordAction">
        <table cellpadding="3" cellspacing="1" align="center" class="tableBorder1">

            <tr bgcolor="lightblue">
                <td height="25" colspan="2" align="center" valign="middle"><font
                        color="#ffffff"><b>输入您的原有密码,新密码</b></font></td>
            </tr>
            <tr>
                <td valign="middle" class="TableBody1">请输入您的旧密码</td>
                <td valign="middle" class="TableBody1"><input name="oldPass" type="text"/></td>
            </tr>
            <tr>
                <td valign="middle" class="TableBody1">请输入您的新密码</td>
                <td valign="middle" class="TableBody1"><input name="newPass1" type="password"> &nbsp;</td>
            </tr>
            <tr>
                <td valign="middle" class="TableBody1">请再次输入您的新密码</td>
                <td valign="middle" class="TableBody1"><input name="newPass2" type="password"> &nbsp;</td>
            </tr>
            <tr>
                <td class="TableBody2" valign="middle" colspan="2" align="center"><input type="submit" value="修改"></td>
            </tr>
        </table>
    </form>
</c:if>
<c:if test="${sessionScope.use == null }">
    <h1 style="color:red;text-align:center;">您还未登陆</h1>
    <div align="center">
        <a href="${path }/UserManageView.jsp"><input type="button" value="返回"></a>
    </div>
</c:if>
&nbsp;<br/>
</body>
</html>