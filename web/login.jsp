<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <script src="js/jquery-3.6.2.js" type="text/javascript" charset="UTF-8"></script>
    <script src="js/jquery.validate.min.js" type="text/javascript" charset="UTF-8"></script>
    <script src="js/login.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body>
    <c:if test="${requestScope.flag==1}">
        <script>
            alert("登录失败")
        </script>
    </c:if>
    <div class="header">
        <div class="title">
            用户登录
        </div>
        <div class="back-to-idx">
            <a href="index.jsp">返回首页</a>
        </div>
    </div>
    <div class="form-container">
        <form action="<%=request.getContextPath()%>/login.do" method="post" class="login-form">
            <h1>登录</h1>
            <label>
                用户名：
                <input type="text" name="user_id" placeholder="账号">
            </label>
            <label>
                密码：
                <input type="password" name="user_pwd" placeholder="密码">
            </label>
            <button>登录</button>
        </form>
        <div class="go-register">
            没有账号？马上
            <a href="register.jsp">
                注册
            </a>
        </div>
    </div>
</body>
</html>
