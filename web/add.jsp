<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/2/6
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加货物</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <script src="js/jquery-3.6.2.js" type="text/javascript" charset="UTF-8"></script>
    <script src="js/jquery.validate.min.js" type="text/javascript" charset="UTF-8"></script>
    <script src="js/add.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body>
<div class="header">
    <div class="title">
        添加货物
    </div>
    <div class="back-to-idx">
        <a href="index.jsp">返回首页</a>
    </div>
</div>
<div class="form-container">
    <form action="<%=request.getContextPath()%>/addGood.do" method="post" class="reg-form">
        <h1>货物信息</h1>
        <label>
            货物名：
            <input type="text" name="name" placeholder="货物名" >
            <label id="notice"></label>
        </label>
        <label>
            货物编号：
            <input type="text" name="good_id" placeholder="货物编号" onblur="checkGoods()" id="goodID">
        </label>
        <label>
            种类：
            <input type="radio" name="category" value="00" checked="checked">办公
            <input type="radio" name="category" value="01">食品
            <input type="radio" name="category" value="02">电器
            <input type="radio" name="category" value="01">其他
        </label>
        <label>
            价格：
            <input type="text" name="price">
        </label>
        <label>
            库存量：
            <input type="text" name="stock">
        </label>
        <label>
            图片：
            <input type="image" name="image" alt="暂无图片">
        </label>
        <label>
            货物细节：
            <input type="text" name="detail">
        </label>
        <button>加入货物</button>
    </form>
</div>
</body>
</html>
