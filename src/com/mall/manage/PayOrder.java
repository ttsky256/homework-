package com.mall.manage;

import com.mall.dbc.DBConnection;
import com.mall.entity.Log;
import com.mall.entity.User;
import com.mall.service.LogFunction;
import com.mall.service.OrderFunction;
import com.mall.service.SendEmail;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

@WebServlet("/pay.do")
public class PayOrder extends HttpServlet
{

    @Serial
    private static final long serialVersionUID = -1792957893483947931L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        int order_id =  Integer.parseInt(request.getParameter("order_id"));
        OrderFunction.pay(order_id);

        User user = (User) request.getSession().getAttribute("user");
        String mail = "您于" + DBConnection.getCurrentTime() + "支付的订单已提交，请等待发货。";
        SendEmail sendEmail = new SendEmail(user.getEmail(), "订单受理通知", mail);
        try {
            sendEmail.send();
        }
        catch (MessagingException e)
        {
            e.printStackTrace();
        }

        String user_id = (String) request.getSession().getAttribute("user_id");
        String[] goods = OrderFunction.getGoods(order_id).split("#");
        for(String good : goods)
        {
            int good_id = Integer.parseInt(good.split("x")[0]);
            int count = Integer.parseInt(good.split("x")[1]);
            Log log = new Log(0, user_id, good_id, count, DBConnection.getCurrentTime(), "pay");
            LogFunction.insert(log);
        }
    }
}
