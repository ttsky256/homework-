package com.mall.manage;
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

@WebServlet("/updateGoods.do")
public class UpdateGoods extends HttpServlet{
    @Serial
    private static final long serialVersionUID = 1059303430762940195L;

    public UpdateGoods()
    {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        int good_id= (int) request.getSession().getAttribute("good_id");


        int price = Integer.parseInt(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        String image = request.getParameter("image");
        String detail = request.getParameter("detail");
        Good good = new Good(good_id, "", "", price, stock, image, detail);
        int count = GoodFunction.updateGood(good);

        PrintWriter writer = response.getWriter();
        if(count > 0)
        {
            writer.write("<script language='javascript'>alert('修改成功，点击返回首页');" +
                    "window.location.href = 'index.jsp'</script>");
        }
        else
        {
            writer.write("<script language='javascript'>alert('修改失败');" +
                    "window.location.href = 'index.jsp'</script>");
        }
    }
}
