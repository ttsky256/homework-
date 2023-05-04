package com.mall.manage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

@WebServlet("/exit.do")
public class ExitUser extends HttpServlet
{
    public ExitUser()
    {
        super();
    }

    @Serial
    private static final long serialVersionUID = 359264472753325957L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        request.getSession().setAttribute("user_id", null);
        request.getSession().setAttribute("user_tag", null);
        request.getSession().setAttribute("user", null);
        request.getSession().setAttribute("orderList", null);
        request.getSession().setAttribute("orders", null);
        request.getSession().setAttribute("cartList", null);
    }
}
