package com.mall.manage;

import com.mall.entity.Good;
import com.mall.entity.User;
import com.mall.service.GoodFunction;
import com.mall.service.UserFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.util.List;
@WebServlet("/loadworker.do")
public class LoadWorker extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -3169679523022943938L;

    public LoadWorker()
    {
        super();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        List<User> list2 = UserFunction.loadUsers();
        request.getSession().setAttribute("list2", list2);
        request.getRequestDispatcher("/owner.jsp").forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
