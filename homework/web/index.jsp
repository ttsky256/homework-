<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lhq
  Date: 2022/12/14
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>系统首页</title>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="css/index.css">
  <script src="js/jquery-3.6.2.js" type="text/javascript" charset="UTF-8"></script>
  <script src="js/jquery.validate.min.js" type="text/javascript" charset="UTF-8"></script>
  <script src="js/index.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body >
  <div class="header">
    <div class="mall-title">
      <a href="index.jsp">
        欢迎来到商城
      </a>

    </div>
    <div class="navigation-container">
      <div class="welcome">
          <c:if test="${sessionScope.user_id==null}">
            <div class="welcome-word">
              请<a href="login.jsp">登录</a>，若是访客请在登录界面注册
            </div>
          </c:if>
        <c:if test="${sessionScope.user_id!=null}">
          <div class="welcome-word" onclick="window.location.href = 'user.jsp'" style="cursor: pointer">
            用户 <%=request.getSession().getAttribute("user_id")%>
          </div>
        </c:if>
      </div>
      <div class="car-container">
        <c:if test="${sessionScope.user_id != null}">
          <a href="cart.jsp">
            <img src="img/cart.png" alt="cart">
            <span>
              购物车
            </span>
          </a>
        </c:if>
      </div>
      <c:if test="${sessionScope.user_id != null}">
        <div class="user-orders">
          <a href="orders.jsp">
            我的订单
          </a>
        </div>
      </c:if>
      <c:if test="${sessionScope.user_id != null}">
        <div class="user-adds">
          <a href="add.jsp">
            添加货物
          </a>
        </div>
      </c:if>
    </div>
  </div>
  <div class="header2">

  </div>
  <div class="content-container"  id="cc">

    <div class="content" >

      <c:forEach var="good" items="${sessionScope.list}" varStatus="s">
        <div class="block">
          <div class="good-name">
              <a href="detail.do?id=${good.good_id}">
                ${good.name}
              </a>
          </div>
          <l href="detail.do?id=${good.good_id}">
            <img src="${good.image}" alt="${good.name}">
          </l>

          <div class="price">
              价格：${good.price}元
          </div>
          <div class="stock">
            库存：${good.stock}件
          </div>
          <div class="good-detail">
              ${good.detail}
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
</body>
</html>
