package com.mall.manage;

import com.mall.dbc.DBConnection;
import com.mall.entity.Good;
import com.mall.entity.Log;
import com.mall.service.GoodFunction;
import com.mall.service.LogFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.sql.Timestamp;

@WebServlet("/detail.do")
public class ShowDetail extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 2408465879358228201L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");


        String id_s = request.getParameter("id");
        int id = Integer.parseInt(id_s);
        Good good = GoodFunction.findGood(id);
        int good_id=good.getGood_id();
        Object uid = request.getSession().getAttribute("user_id");
        if(uid != null)
        {
            String user_id = (String) uid;
            Timestamp currentTime = DBConnection.getCurrentTime();
            int log_id2=0;
            Log log = new Log(log_id2, user_id, id, 0, currentTime, "view");
            LogFunction.insert(log);
        }

        request.getSession().setAttribute("good", good);
        request.getSession().setAttribute("good_id", good_id);
        request.getRequestDispatcher("/detail.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        doGet(request, response);
    }
}
