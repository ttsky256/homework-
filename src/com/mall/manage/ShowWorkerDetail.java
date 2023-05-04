package com.mall.manage;

import com.mall.dbc.DBConnection;
import com.mall.entity.Good;
import com.mall.entity.Log;
import com.mall.entity.User;
import com.mall.service.GoodFunction;
import com.mall.service.LogFunction;
import com.mall.service.UserFunction;
import javax.servlet.http.HttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.sql.Timestamp;
@WebServlet("/workerdetail.do")
public class ShowWorkerDetail extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 249982464632342831L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");


        String id = request.getParameter("id");
        User user = UserFunction.findUser(id);
        String worker_id=user.getUser_id();


        request.getSession().setAttribute("worker", user);
        request.getSession().setAttribute("worker_id", worker_id);
        request.getRequestDispatcher("/workerdetail.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        doGet(request, response);
    }
}
