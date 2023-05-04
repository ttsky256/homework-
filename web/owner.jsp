<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/5/3
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员界面</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <script src="js/jquery-3.6.2.js" type="text/javascript" charset="UTF-8"></script>
    <script src="js/jquery.validate.min.js" type="text/javascript" charset="UTF-8"></script>
    <script src="js/owner.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body>
<div class="header">
    <div class="mall-title">
        <a href="index.jsp">
            欢迎来到商城管理
        </a>
    </div>
    <div class="navigation-container">
    <div class="user-adds">
        <a href="register2.jsp">
            添加销售人员
        </a>
    </div>
    </div>
</div>
<div class="content-container"  id="ccc">

    <div class="content" >
        <c:forEach var="user" items="${sessionScope.list2}" varStatus="s">
            <div class="block">
                <div class="good-name">
                    <a href="workerdetail.do?id=${user.user_id}">
                            ${user.user_id}
                    </a>
                </div>

                <div class="price">
                    标签${user.tag}
                </div>
            </div>
        </c:forEach>
    </div>

</div>
<div class="detail">
    注，0代表用户，1代表销售人员，2代表管理员
</div>
</body>
</html>
