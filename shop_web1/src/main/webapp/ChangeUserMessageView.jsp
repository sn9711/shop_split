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
    <form method="post" action="${path }/l/ChangeUserMessageAction">
        <table cellpadding="3" cellspacing="1" align="center" class="tableBorder1" id="table1">
            <tr>
                <td valign="middle" colspan="2" align="center" height="25" bgcolor="lightblue">
                    <font color="#ffffff"><b>用户信息修改</b></font></td>
            </tr>


            <tr>
                <td width="40%" class="TableBody1"><b>用户名</b>：</td>
                <td width="60%" class="TableBody1">
                    <input type="text" name="username" maxlength="16" size="32" value="${sessionScope.use.username }"
                           style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000"
                           readonly>
                </td>
            </tr>
            <tr>
                <td width="40%" class="TableBody1"><b>密码</b>:</td>
                <td width="60%" class="TableBody1">
                    <input type="text" name="password" size="32" value="${sessionScope.use.password }"
                           style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000"
                           readonly></td>
            </tr>
            <tr>
                <td class="TableBody1"><b>真实姓名</b>：</td>
                <td class="TableBody1">
                    <input type="text" name="name" maxlength="32" size="64" value="${sessionScope.use.name }"
                           style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
                </td>
            </tr>
            <tr>
                <td class="TableBody1"><b>联系地址</b>：</td>
                <td class="TableBody1">
                    <input type="text" name="address" maxlength="32" size="64" value="${sessionScope.use.address }"
                           style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
                </td>
            </tr>
            <tr>
                <td class="TableBody1"><b>邮编</b>：</td>
                <td class="TableBody1">
                    <input type="text" name="zip" maxlength="8" size="32" value="${sessionScope.use.zip }"
                           style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
                </td>
            </tr>
            <tr>
                <td class="TableBody2" valign="middle" colspan="2" align="center">
                    <input type="submit" value="修改"></td>
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