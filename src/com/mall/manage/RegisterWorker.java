package com.mall.manage;
//注册新工作人员
import com.mall.entity.User;
import com.mall.service.UserFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
@WebServlet("/register2.do")
public class RegisterWorker extends HttpServlet{

    public RegisterWorker()
        {
            super();
        }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String user_id = request.getParameter("user_id");
        String user_pwd = request.getParameter("user_pwd");
        String sex = request.getParameter("sex");
        String email = request.getParameter("email_address");
        String phone = request.getParameter("phone_num");
        String address = request.getParameter("address");
        String tag = "1";

        User user = new User(user_id, user_pwd, sex, email, phone, address,tag);
        int count = UserFunction.insert(user);
        PrintWriter writer = response.getWriter();

        if(count > 0)
        {
            writer.write("<script language='javascript'>alert('注册成功，点击返回开始界面');" +
                    "window.location.href = 'index.jsp'</script>");
        }
        else
        {
            writer.write("<script language='javascript'>alert('注册失败');" +
                    "window.location.href = 'index.jsp'</script>");
        }

    }
}
