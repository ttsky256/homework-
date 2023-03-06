<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/2/12
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>货物信息</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <script src="js/jquery-3.6.2.js" type="text/javascript" charset="UTF-8"></script>
    <script src="js/jquery.validate.min.js" type="text/javascript" charset="UTF-8"></script>
    <script src="js/updategoods.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body>
<div class="header">
    <div class="title">
        货物详细信息
    </div>
    <div class="back-to-idx">
        <a href="index.jsp">返回首页</a>
    </div>
</div>
<div class="form-container">
    <form action="<%=request.getContextPath()%>/updateGoods.do" method="post" class="reg-form">
        <h1>修改货物信息</h1>
        <label>
            货物编号：${sessionScope.good.good_id}
        </label>
        <label>
            价格：
            <input type="text" name="price" value="${sessionScope.good.price}">
        </label>
        <label>
            库存量：
            <input type="text" name="stock" value="${sessionScope.good.stock}">
        </label>
        <label>
            图片：
            <input type="image" name="image" value="${sessionScope.good.image}" alt="img/phone/1.png">
        </label>
        <label>
            详细信息：
            <input type="text" name="detail" value="${sessionScope.good.detail}">
        </label>
        <button>确认更改</button>
    </form>

</div>
</body>
</html>
