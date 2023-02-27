package com.mall.manage;
//检查货物编号是否唯一
import com.mall.entity.Good;
import com.mall.service.GoodFunction;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
@WebServlet("/checkGoods.do")
public class CheckGoods extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -9006724318168161782L;

    public CheckGoods()
    {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();

        int good_id = Integer.parseInt(request.getParameter("good_id"));
        Good good = GoodFunction.findGood(good_id);
        if(good == null)
        {
            printWriter.write("1");
        }
        else
        {
            printWriter.write("0");
        }
    }
}
