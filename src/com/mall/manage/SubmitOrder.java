package com.mall.manage;

import com.mall.entity.Record;
import com.mall.entity.User;
import com.mall.service.OrderFunction;
import com.mall.service.UserFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet("/submitOrder.do")
public class SubmitOrder extends HttpServlet {

    @Serial
    private static final long serialVersionUID = -6330999695784738116L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String goods = request.getParameter("goods");
        List<Record> orderList = OrderFunction.createOrder(goods);
        String user_id = (String) request.getSession().getAttribute("user_id");
        User user = UserFunction.findUser(user_id);
        int total = 0;

        for(Record order : orderList)
        {
            total += order.getTotalPrice();
        }

        request.getSession().setAttribute("orderList", orderList);
        request.getSession().setAttribute("total", total);
        request.getSession().setAttribute("user", user);
    }
}
