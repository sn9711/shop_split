<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    session.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML>

<html>
<head>
    <style type="text/css">
        .c1 {
            text-align: right;
            margin-right: 50px
        }

        .c2 {
            text-align: right;
            margin-right: 50px;
            color: blue;
            font-size: 150%
        }

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

        .b {
            background-color: yellow;
            background-image: url("${path }/image/button12.gif");
            width: 60px;
            height: 30px;
            border: none
        }

    </style>
</head>
<body>&nbsp;

<!-- 动态包含 -->
<jsp:include page="Include.jsp"></jsp:include>

<table border="1" bordercolor="blue" cellspacing="0" align="center" width="70%">
    <tr align="center" bgcolor="lightblue">
        <td><b>Id</b></td>
        <td><b>Name</b></td>
        <td><b>图片</b></td>
        <td><b>Price</b></td>
        <td><b><img src="${path }/image/car_new.gif"/></b></td>
    </tr>
    <c:forEach items="${pagepros }" var="pro">
        <tr align="center">
            <td>${pro.id }</td>
            <td>${pro.productName }</td>
            <td><img src="${path }${pro.picpath }"/></td>
            <td>${pro.price }</td>
            <td align="center"><a href="${path }/l/AddCarAction?id=${pro.id }"><img
                    src="${path }/image/car_new.gif"/></a></td>
        </tr>
    </c:forEach>
</table>
<p>&nbsp;</p>

<!-- 分页 -->
<div align="center">
    <a href="${path }/SelectProductAction?page=1&&productName=${productName }&&opt=${opt }&&price=${strprice }">首页</a>&nbsp;&nbsp;
    <c:if test="${page>1}">
        <a href="${path }/SelectProductAction?page=${page-1 }&&productName=${productName }&&opt=${opt }&&price=${strprice }">上一页</a>&nbsp;&nbsp;
    </c:if>

    <c:if test="${page>=3 }">
        <c:if test="${page+1<=pages }">
            <c:forEach begin="${page-1 }" end="${page+1 }" var="i">
                <c:if test="${page==i }">
                    <a href="${path }/SelectProductAction?page=${i }&&productName=${productName }&&opt=${opt }&&price=${strprice }"
                       style="color:red;background-color:black;">${i }</a>&nbsp;&nbsp;
                </c:if>
                <c:if test="${page !=i }">
                    <a href="${path }/SelectProductAction?page=${i }&&productName=${productName }&&opt=${opt }&&price=${strprice }">${i }</a>&nbsp;&nbsp;
                </c:if>
            </c:forEach>
        </c:if>
        <c:if test="${page+1>pages }">
            <c:forEach begin="${page-1 }" end="${pages }" var="i">
                <c:if test="${page==i }">
                    <a href="${path }/SelectProductAction?page=${i }&&productName=${productName }&&opt=${opt }&&price=${strprice }"
                       style="color:red;background-color:black;">${i }</a>&nbsp;&nbsp;
                </c:if>
                <c:if test="${page !=i }">
                    <a href="${path }/SelectProductAction?page=${i }&&productName=${productName }&&opt=${opt }&&price=${strprice }">${i }</a>&nbsp;&nbsp;
                </c:if>
            </c:forEach>
        </c:if>
    </c:if>

    <c:if test="${page<3 }">
        <c:if test="${pages<3 }">
            <c:forEach begin="1" end="${pages }" var="i">
                <c:if test="${page ==i }">
                    <a href="${path }/SelectProductAction?page=${i }&&productName=${productName }&&opt=${opt }&&price=${strprice }"
                       style="color:red;background-color:black;">${i }</a>&nbsp;&nbsp;
                </c:if>
                <c:if test="${page !=i }">
                    <a href="${path }/SelectProductAction?page=${i }&&productName=${productName }&&opt=${opt }&&price=${strprice }">${i }</a>&nbsp;&nbsp;
                </c:if>
            </c:forEach>
        </c:if>
        <c:if test="${pages>=3 }">
            <c:forEach begin="1" end="3" var="i">
                <c:if test="${page ==i }">
                    <a href="${path }/SelectProductAction?page=${i }&&productName=${productName }&&opt=${opt }&&price=${strprice }"
                       style="color:red;background-color:black;">${i }</a>&nbsp;&nbsp;
                </c:if>
                <c:if test="${page !=i }">
                    <a href="${path }/SelectProductAction?page=${i }&&productName=${productName }&&opt=${opt }&&price=${strprice }">${i }</a>&nbsp;&nbsp;
                </c:if>
            </c:forEach>
        </c:if>
    </c:if>

    <c:if test="${(page+1)<=pages }">
        <a href="${path }/SelectProductAction?page=${page+1 }&&productName=${productName }&&opt=${opt }&&price=${strprice }">下一页</a>&nbsp;&nbsp;
    </c:if>
    <a href="${path }/SelectProductAction?page=${pages }&&productName=${productName }&&opt=${opt }&&price=${strprice }">尾页</a>&nbsp;&nbsp;
</div>

</body>
</html>