package com.mall.manage;
//将货物加入购物车
import com.mall.entity.Cart;
import com.mall.entity.Good;
import com.mall.service.CartFunction;
import com.mall.service.GoodFunction;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

@WebServlet("/addCart.do")
public class AddCart extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 6639160241741431019L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();

        String user_id = (String) request.getSession().getAttribute("user_id");
        Good good = (Good) request.getSession().getAttribute("good");
        int good_id = good.getGood_id();
        int count = Integer.parseInt(request.getParameter("count"));

        int stock = GoodFunction.findStock(good_id);
        if(stock < count)
        {
            printWriter.print("<script language='javascript'>alert('库存不足')</script>");
            return;
        }

        Cart cart = new Cart(0, user_id, good_id, count);
        int c = CartFunction.insert(cart);

        if(c > 0)
        {
            printWriter.print("<script language='javascript'>alert('加入购物车成功');window.location.href='index.jsp';</script>");
        }
        else
        {
            printWriter.print("<script language='javascript'>alert('加入购物车失败')</script>");
        }
    }
}
