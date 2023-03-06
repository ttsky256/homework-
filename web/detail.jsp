<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品详情</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/detail.css">
    <script src="js/jquery-3.6.2.js" type="text/javascript" charset="UTF-8"></script>
    <script src="js/jquery.validate.min.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body>
    <div class="header">
        <div class="mall-title">
            <a href="index.jsp">
                商城主页
            </a>
        </div>
        <div class="welcome">
            <c:if test="${sessionScope.user_id==null}">
                <div class="welcome-word">
                    用户未登录，请<a href="login.jsp">登录</a>
                </div>
            </c:if>
            <c:if test="${sessionScope.user_id!=null}">
                <div class="welcome-word">
                    用户<%=request.getSession().getAttribute("user_id")%>已登录
                </div>
            </c:if>
        </div>
        <div class="navigation-container">
            <div class="goods">
                商品详情
            </div>

            <div class="car-container">
                <c:if test="${sessionScope.user_id != null}">
                <a href="cart.jsp">
                    <img src="img/cart.png">
                    <span>
                    购物车
                    </span>
                </a>
                </c:if>
            </div>
        </div>
    </div>
    <div class="content-container">
        <div class="content">
            <img src="${sessionScope.good.image}" alt="${sessionScope.good.name}">
            <div class="right-container">
                <div class="name">
                    ${sessionScope.good.name}
                </div>
                <div class="detail">
                    细节：${sessionScope.good.detail}
                </div>
                <div class="price">
                    价格：${sessionScope.good.price}元
                </div>
                <div class="stock">
                    库存：${sessionScope.good.stock}件
                </div>
                <form action="<%=request.getContextPath()%>/addCart.do" method="post" class="add-cart-form">
                    <label>
                        购买数量：
                        <input type="text" onkeyup="value=value.replace(/[^\d]/g, '')" name="count" id="good-count" value="1">
                    </label>
                    <c:if test="${sessionScope.user_id == null}">
                        <button id="add-cart-btn-disabled" disabled="disabled">要加入购物车，请先登录</button>
                    </c:if>
                    <c:if test="${sessionScope.user_id != null}">
                        <button id="add-cart-btn">加入购物车</button>
                    </c:if>
                </form>
                <c:if test="${sessionScope.user_id != null}">
                    <div class="updateGoods">
                        <a href="updategoods.jsp">
                            修改货物信息
                        </a>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</body>
</html>
