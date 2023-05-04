<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/5/4
  Time: 0:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户详情</title>
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
</div>
<div class="content-container">
  <div class="content">
    <div class="right-container">
      <div class="name">
        ${sessionScope.worker.user_id}
      </div>

      <div class="price">
        电话：${sessionScope.worker.phone}
      </div>
      <div class="stock">
        标签：${sessionScope.worker.tag}
      </div>

      <%--<c:if test="${sessionScope.user_id != null&&sessionScope.worker.tag=='1'}">
        <div class="updateGoods">
          <a href="updateworkers.jsp">
            修改销售人员信息
          </a>
        </div>
      </c:if>--%>
    </div>
  </div>
</div>
</body>
</html>
