package com.mall.manage;
import com.mall.entity.Good;
import com.mall.service.GoodFunction;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
@WebServlet("/findOneGood.do")
public class FindOneGood extends HttpServlet{
    @Serial
    private static final long serialVersionUID = -6221802030989869545L;

    public FindOneGood()
    {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        int  good_id = Integer.parseInt((String) request.getSession().getAttribute("good_id"));
        Good good = GoodFunction.findGood(good_id);
        request.getSession().setAttribute("good", good);
    }
}
