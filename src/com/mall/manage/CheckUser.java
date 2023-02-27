package com.mall.manage;
//检查用户名是否唯一
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

@WebServlet("/checkUser.do")
public class CheckUser extends HttpServlet
{
    public CheckUser()
    {
        super();
    }

    @Serial
    private static final long serialVersionUID = -4522037858938994568L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();

        String user_id = request.getParameter("user_id");
        User user = UserFunction.findUser(user_id);
        if(user == null)
        {
            printWriter.write("1");
        }
        else
        {
            printWriter.write("0");
        }
    }
}
