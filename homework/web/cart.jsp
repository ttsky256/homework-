<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lhq
  Date: 2022/12/17
  Time: 3:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/cart.css">
    <script src="js/jquery-3.6.2.js" type="text/javascript" charset="UTF-8"></script>
    <script src="js/jquery.validate.min.js" type="text/javascript" charset="UTF-8"></script>
    <script src="js/cart.js" type="text/javascript" charset="UTF-8"></script>
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
                    你好，请<a href="login.jsp">登录</a>
                </div>
            </c:if>
            <c:if test="${sessionScope.user_id!=null}">
                <div class="welcome-word">
                    用户<%=request.getSession().getAttribute("user_id")%>的购物车
                </div>
            </c:if>
        </div>
        <div class="car-container">
            <a>
                <img src="img/cart.png" alt="购物车">

            </a>
        </div>
    </div>
</div>
<div class="content-container" id="cc">
    <div class="content">
        <c:if test="${sessionScope.cartList == null}">
            <div class="nothing-in-cart">
                你的购物车里还没有东西，快去商城逛逛吧
            </div>
        </c:if>
        <c:if test="${sessionScope.cartList != null}">
            <div class="title-container">
                <div class="good-title">
                    商品信息
                </div>
                <div class="count-title">
                    预购买数量
                </div>
                <div class="price-title">
                    价格
                </div>
                <div class="select-title">
                    选中状态
                </div>
            </div>
        </c:if>
        <c:forEach var="record" items="${sessionScope.cartList}" varStatus="s">
            <div class="block">
                <div class="good-container">
                    <div class="name">
                            ${record.name}
                    </div>
                    <img src="${record.image}" alt="p">

                </div>
                <div class="count">
                    ${record.count}件
                </div>
                <div class="total-price">
                    ${record.totalPrice}元
                </div>
                <label>
                    <input type="checkbox" name="select" value="${record.record_id}~${record.good_id}x${record.count}">
                </label>
            </div>
        </c:forEach>
        <c:if test="${sessionScope.cartList != null}">
            <button onclick="submitOrder()">提交订单</button>
        </c:if>
    </div>
</div>
</body>
</html>
