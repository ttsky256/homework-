package com.mall.manage;
//增加货物
import com.mall.entity.Good;
import com.mall.service.GoodFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
@WebServlet("/addGood.do")
public class AddGood extends HttpServlet{

    @Serial
    private static final long serialVersionUID = -6659168925559886680L;

    public AddGood()
    {
        super();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        int good_id = Integer.parseInt(request.getParameter("good_id"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String category = request.getParameter("category");
        int stock = Integer.parseInt(request.getParameter("stock"));
        String image = request.getParameter("image");
        String detail = request.getParameter("detail");


        Good good = new Good(good_id, name, category,price,stock, image,detail);
        int count = GoodFunction.insert(good);
        PrintWriter writer = response.getWriter();

        if(count > 0)
        {
            writer.write("<script language='javascript'>alert('加入货物成功，点击返回添加界面');" +
                    "window.location.href = 'index.jsp'</script>");//??
        }
        else
        {
            writer.write("<script language='javascript'>alert('加入货物失败');" +
                    "window.location.href = 'index.jsp'</script>");//
        }
    }

}
