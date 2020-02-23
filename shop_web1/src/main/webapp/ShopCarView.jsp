<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    session.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML>

<html>
<head>
    <script src="${path }/js/shopcar.js"></script>
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

    </style>
</head>
<body>&nbsp;

<!-- 动态包含 -->
<jsp:include page="Include.jsp"></jsp:include>


<form action="${path }/l/UpdateNumAction" method="post">
    <table border="1" bordercolor="blue" cellspacing="0" align="center" width="80%">
        <tbody id="tbody">
        <tr bgcolor="lightblue" align="center">
            <td><b>&nbsp;</b></td>
            <td><b>商品编号</b></td>
            <td><b>商品名称</b></td>
            <td><b>图片</b></td>
            <td><b>商品单价</b></td>
            <td><b>数量</b></td>
            <td><b>总价</b></td>
            <td><b>删除</b></td>
        </tr>
        <c:forEach items="${sessionScope.map }" var="m">
            <tr onmouseover="over(this);" onmouseout="out(this);" align="center">
                <td><input type="checkbox" name="ids" value="${m.value.id }"/></td>
                <td>${m.value.id }</td>
                <td>${m.value.name }</td>
                <td><img src="${path }${m.value.pic }"/></td>
                <td>${m.value.price }</td>
                <td>
                    <input type="button" value="-" onclick="sub(this);"/><input type="text" value="${m.value.num }"
                                                                                size="1" maxlength="1" name="1"/><input
                        type="button" value="+" onclick="add(this);"/>
                </td>
                <td>${m.value.price*m.value.num }</td>
                <td><a href="${path }/l/DeleteOneAction?id=${m.value.id }"><input type="button" value="delete"/></a>
                </td>
            </tr>
        </c:forEach>


        <tr align="center">
            <td colspan="7">
                <input type="button" value="选中所有行" onclick="selectAll();"/>
                <input type="button" value="取消选中" onclick="quxiao();"/>
                <input type="button" value="删除选中的行" onclick="deleteSelected();"/>
            </td>
        </tr>

        </tbody>
    </table>
    <center><p><input type="submit" value="提交修改" onclick="selectAll();"/></p></center>
</form>
<center>
    <hr/>
    <a href="">提交订单</a>
    <hr/>
</center>
<!-- 回收站 -->
<table border="1" bordercolor="blue" cellspacing="0" align="center" width="80%">
    <tbody id="tbody">
    <tr bgcolor="lightblue" align="center">
        <td><b>&nbsp;</b></td>
        <td><b>商品编号</b></td>
        <td><b>商品名称</b></td>
        <td><b>图片</b></td>
        <td><b>商品单价</b></td>
        <td><b>数量</b></td>
        <td><b>总价</b></td>
        <td><b>删除</b></td>
    </tr>
    <c:forEach items="${sessionScope.demap }" var="m">
        <tr onmouseover="over(this);" onmouseout="out(this);" align="center">
            <td><input type="checkbox" name="reids" value="${m.value.id }"/></td>
            <td>${m.value.id }</td>
            <td>${m.value.name }</td>
            <td><img src="${path }${m.value.pic }"/></td>
            <td>${m.value.price }</td>
            <td>
                <input type="button" value="-" onclick="sub(this);"/><input type="text" value="${m.value.num }" size="1"
                                                                            maxlength="1" name="1"/><input type="button"
                                                                                                           value="+"
                                                                                                           onclick="add(this);"/>
            </td>
            <td>${m.value.price*m.value.num }</td>
            <td><a href="${path }/l/RecoverProduct?id=${m.value.id }"><input type="button" value="恢复"/></a></td>
        </tr>
    </c:forEach>


    <tr align="center">
        <td colspan="7">
            <input type="button" value="选中所有行" onclick="selectAll();"/>
            <input type="button" value="取消选中" onclick="quxiao();"/>
            <input type="button" value="删除选中的行" onclick="deleteSelected();"/>
        </td>
    </tr>

    </tbody>
</table>


</body>
</html>