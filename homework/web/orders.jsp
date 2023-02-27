<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lhq
  Date: 2022/12/18
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>我的订单</title>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="css/orders.css">
  <script src="js/jquery-3.6.2.js" type="text/javascript" charset="UTF-8"></script>
  <script src="js/jquery.validate.min.js" type="text/javascript" charset="UTF-8"></script>
  <script src="js/orders.js" type="text/javascript" charset="UTF-8"></script>
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
          <%=request.getSession().getAttribute("user_id")%>，这是你的订单
        </div>
      </c:if>
    </div>
    <div class="car-container">
      <c:if test="${sessionScope.user_id == null}">
        <a href="login.jsp">
          <img src="img/cart.png" alt="cart">
          <span>
              购物车
            </span>
        </a>
      </c:if>
      <c:if test="${sessionScope.user_id != null}">
        <a href="cart.jsp">
          <img src="img/cart.png" alt="cart">
          <span>
            购物车
          </span>
        </a>
      </c:if>
    </div>
  </div>
</div>
<div class="content-container" id="cc">
  <div class="content">
    <div class="title-container">
      <div class="ctime-title">
        订单创建时间
      </div>
      <div class="price-title">
        订单总额/元
      </div>
    </div>
    <c:forEach var="ord" items="${sessionScope.orders}" varStatus="s">
      <div class="block">
        <div class="ctime">
            ${ord.createTime}
        </div>
        <div class="price">
            ${ord.total_price}
        </div>
        <div class="dynamic-container">
          <c:if test="${ord.payTime == null}">
            <div class="button-container">
              <button onclick="cancelOrder(this)" value="${ord.order_id}">取消订单</button>
              <button onclick="payOrder(this)" value="${ord.order_id}">进行付款</button>
            </div>
          </c:if>
          <c:if test="${ord.payTime != null}">
            <div class="payed-word">
              已付款，等待运输
            </div>
          </c:if>
        </div>
      </div>
    </c:forEach>
  </div>
</div>
</body>
</html>
