package com.mall.manage;

import com.mall.dbc.DBConnection;
import com.mall.entity.Log;
import com.mall.entity.Order;
import com.mall.entity.Record;
import com.mall.entity.User;
import com.mall.service.*;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.sql.Timestamp;
import java.util.List;

@WebServlet("/confirm.do")
public class ConfirmOrder extends HttpServlet
{

    @Serial
    private static final long serialVersionUID = -4238472686339991601L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String user_id = (String) request.getSession().getAttribute("user_id");
        User user = (User) request.getSession().getAttribute("user");
        int total_price = (int) request.getSession().getAttribute("total");
        StringBuilder goodStr = new StringBuilder();
        List<Record> records = (List<Record>) request.getSession().getAttribute("orderList");
        for(Record record : records)
        {
            goodStr.append(record.getGood_id()).append("x").append(record.getCount()).append("#");
        }
        goodStr.deleteCharAt(goodStr.length() - 1);
        Timestamp createTime = DBConnection.getCurrentTime();
        Timestamp payTime = null;
        if(request.getParameter("pay").equals("1"))
        {
            payTime = DBConnection.getCurrentTime();

            String mail = "您于" + payTime + "支付的订单已提交，请等待发货。";
            SendEmail sendEmail = new SendEmail(user.getEmail(), "订单受理通知", mail);
            System.out.println(payTime);
            try {
                sendEmail.send();
            }
            catch (MessagingException e)
            {
                e.printStackTrace();
            }
            System.out.println(payTime);
        }

        Order order = new Order(0, user_id, total_price, goodStr.toString(), createTime, payTime);
        OrderFunction.insert(order);

        for(Record record : records)
        {
            CartFunction.deleteRecord(record.getRecord_id());
            GoodFunction.sell(record.getGood_id(), record.getCount());
            int log_id1=0;
            Log log = new Log(log_id1, user_id, record.getGood_id(), record.getCount(), createTime, "smt");
            LogFunction.insert(log);
            if(payTime != null)
            {
                log.setTime(payTime);
                log.setAct("pay");
                LogFunction.insert(log);
            }
            else
            {System.out.println("MY");}
            System.out.println(payTime);
        }

        request.getSession().setAttribute("total", null);
        request.getSession().setAttribute("orderList", null);
        request.getSession().setAttribute("user", null);
    }
}
