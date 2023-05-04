
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <script src="js/jquery-3.6.2.js" type="text/javascript" charset="UTF-8"></script>
    <script src="js/jquery.validate.min.js" type="text/javascript" charset="UTF-8"></script>
    <script src="js/user.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body>
<div class="header">
    <div class="title">
        用户信息
    </div>
    <div class="back-to-idx">
        <a href="index.jsp">返回首页</a>
    </div>
</div>
<div class="form-container">
    <form action="<%=request.getContextPath()%>/update.do" method="post" class="reg-form">
        <h1>修改信息</h1>
        <label>
            用户名：${sessionScope.user_id}
        </label>
        <label>
            电子邮件：
            <input type="text" name="email_address" value="${sessionScope.user.email}">
        </label>
        <label>
            电话号码：
            <input type="text" name="phone_num" value="${sessionScope.user.phone}">
        </label>
        <label>
            收货地址：
            <input type="text" name="address" value="${sessionScope.user.address}">
        </label>
        <label>
            标签：
            <input type="text" name="tag" value="${sessionScope.user.tag}">
        </label>
        <button>确认更改</button>
    </form>

</div>
<button onclick="exit()" id="exit-btn">退出登录</button>
</body>
</html>
