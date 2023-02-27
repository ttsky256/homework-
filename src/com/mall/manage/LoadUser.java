package com.mall.manage;

import com.mall.entity.User;
import com.mall.service.UserFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

@WebServlet("/loadUser.do")
public class LoadUser extends HttpServlet
{
    public LoadUser()
    {
        super();
    }

    @Serial
    private static final long serialVersionUID = -3738974400580237211L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String user_id = (String) request.getSession().getAttribute("user_id");
        User user = UserFunction.findUser(user_id);
        request.getSession().setAttribute("user", user);
    }
}
