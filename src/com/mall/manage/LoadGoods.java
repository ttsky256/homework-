package com.mall.manage;

import com.mall.entity.Good;
import com.mall.service.GoodFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet(urlPatterns = "/load.do", loadOnStartup = 1)
public class LoadGoods extends HttpServlet {
    public LoadGoods()
    {
        super();
    }

    @Serial
    private static final long serialVersionUID = -7179895916192766734L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        List<Good> list = GoodFunction.loadGoods();
        request.getSession().setAttribute("list", list);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
