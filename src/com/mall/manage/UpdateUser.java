package com.mall.manage;

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

@WebServlet("/update.do")
public class UpdateUser extends HttpServlet
{
    public UpdateUser()
    {
        super();
    }

    @Serial
    private static final long serialVersionUID = 4816212920054007883L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String user_id = (String) request.getSession().getAttribute("user_id");
        String email = request.getParameter("email_address");
        String phone = request.getParameter("phone_num");
        String address = request.getParameter("address");
        User user = new User(user_id, "", "", email, phone, address);
        int count = UserFunction.updateUser(user);

        PrintWriter writer = response.getWriter();
        if(count > 0)
        {
            writer.write("<script language='javascript'>alert('修改成功，点击返回首页');" +
                    "window.location.href = 'index.jsp'</script>");
        }
        else
        {
            writer.write("<script language='javascript'>alert('修改失败');" +
                    "window.location.href = 'user.jsp'</script>");
        }
    }
}
