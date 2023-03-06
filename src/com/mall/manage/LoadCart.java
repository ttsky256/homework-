package com.mall.manage;

import com.mall.entity.Record;
import com.mall.service.CartFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet(urlPatterns = "/loadCart.do", loadOnStartup = 1)
public class LoadCart extends HttpServlet
{
    public LoadCart()
    {
        super();
    }

    @Serial
    private static final long serialVersionUID = -2682292197836398449L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String uid = (String) request.getSession().getAttribute("user_id");
        List<Record> cartList = CartFunction.loadRecords(uid);
        if(cartList.size() > 0)
        {
            request.getSession().setAttribute("cartList", cartList);
        }
        else
        {
            request.getSession().setAttribute("cartList", null);
        }
        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
