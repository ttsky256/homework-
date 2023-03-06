package com.mall.manage;

import com.mall.entity.Order;
import com.mall.service.OrderFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet("/loadOrders.do")
public class LoadOrders extends HttpServlet
{
    public LoadOrders()
    {
        super();
    }

    @Serial
    private static final long serialVersionUID = -1546386636226969235L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String user_id = (String) request.getSession().getAttribute("user_id");
        List<Order> orders = OrderFunction.getOrders(user_id);

        request.getSession().setAttribute("orders", orders);
        request.getRequestDispatcher("/orders.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
