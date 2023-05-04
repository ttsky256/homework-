package com.mall.manage;

import com.mall.dbc.DBConnection;
import com.mall.entity.Log;
import com.mall.service.GoodFunction;
import com.mall.service.LogFunction;
import com.mall.service.OrderFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

@WebServlet("/cancel.do")
public class CancelOrder extends HttpServlet
{

    @Serial
    private static final long serialVersionUID = -8916306333054665714L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        int order_id = Integer.parseInt(request.getParameter("order_id"));
        String user_id = (String) request.getSession().getAttribute("user_id");

        String[] goods = OrderFunction.getGoods(order_id).split("#");
        for(String good : goods)
        {
            int good_id = Integer.parseInt(good.split("x")[0]);
            int count = Integer.parseInt(good.split("x")[1]);
            GoodFunction.cancel(good_id, count);
            Log log = new Log(0, user_id, good_id, count, DBConnection.getCurrentTime(), "cnl");
            LogFunction.insert(log);
        }

        OrderFunction.cancelOrder(order_id);
    }
}
