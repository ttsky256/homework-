
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <script src="js/jquery-3.6.2.js" type="text/javascript" charset="UTF-8"></script>
    <script src="js/jquery.validate.min.js" type="text/javascript" charset="UTF-8"></script>
    <script src="js/register.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body>
<div class="header">
    <div class="title">
        用户注册
    </div>
    <div class="back-to-idx">
        <a href="index.jsp">返回首页</a>
    </div>
</div>
<div class="form-container">
    <form action="<%=request.getContextPath()%>/register.do" method="post" class="reg-form">
        <h1>用户注册</h1>
        <label>
            用户名：
            <input type="text" name="user_id" placeholder="账号" onblur="checkUser()" id="userID">
            <label id="notice"></label>
        </label>
        <label>
            密码：
            <input type="password" name="user_pwd" placeholder="密码">
        </label>
        <label>
            性别：
            <input type="radio" name="sex" value="m" checked="checked">男
            <input type="radio" name="sex" value="f">女
        </label>
        <label>
            电子邮件：
            <input type="text" name="email_address">
        </label>
        <label>
            电话号码：
            <input type="text" name="phone_num">
        </label>
        <label>
            收货地址：
            <input type="text" name="address">
        </label>
        <button>注册</button>
    </form>
</div>
</body>
</html>
