<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lhq
  Date: 2022/12/18
  Time: 6:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>确认订单</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/confirm.css">
    <script src="js/jquery-3.6.2.js" type="text/javascript" charset="UTF-8"></script>
    <script src="js/jquery.validate.min.js" type="text/javascript" charset="UTF-8"></script>
    <script src="js/confirm.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body>
<div class="header">
    <div class="mall-title">
        <a href="index.jsp">
            商城主页
        </a>
    </div>
    <div class="navigation-container">
        <div class="welcome">
            <c:if test="${sessionScope.user_id==null}">
                <div class="welcome-word">
                    还未登录，请<a href="login.jsp">登录</a>
                </div>
            </c:if>
            <c:if test="${sessionScope.user_id!=null}">
                <div class="welcome-word">
                    <%=request.getSession().getAttribute("user_id")%>已登录
                </div>
            </c:if>
        </div>
    </div>
</div>
<div class="content-container" id="cc">
    <div class="confirm-word">
        确认你的订单！！！一旦售出，概不退款！！！
    </div>
    <div class="content">
        <div class="personal-inf">
            <div class="uid">
                用户名：${sessionScope.user_id}
            </div>
            <div class="phone-number">
                电话号码：${sessionScope.user.phone}
            </div>
            <div class="email-address">
                电子邮件：${sessionScope.user.email}
            </div>
        </div>
        <div class="title-container">
            <div class="name-title">
                商品名称
            </div>
            <div class="count-title">
                数量/件
            </div>
            <div class="price-title">
                价格/元
            </div>
        </div>
        <c:forEach var="order" items="${sessionScope.orderList}" varStatus="s">
            <div class="block">
                <div class="name">
                    ${order.name}
                </div>
                <div class="count">
                    ${order.count}
                </div>
                <div class="price">
                    ${order.totalPrice}
                </div>
            </div>
        </c:forEach>

        <div class="address-total-container">
            <div class="address">
                收件地址：${sessionScope.user.address}
            </div>
            <div class="total-price">
                总价：${sessionScope.total}元
            </div>
        </div>
        <div class="button-container">
            <button onclick="payLater()">稍后付款</button>
            <button onclick="payNow()">立刻付款</button>
        </div>
    </div>
</div>
</body>
</html>
