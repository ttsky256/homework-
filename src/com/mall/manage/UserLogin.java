package com.mall.manage;

import com.mall.service.UserFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serial;

import static com.mall.service.UserFunction.findUserTag;


@WebServlet("/login.do")
public class UserLogin extends HttpServlet {

    @Serial
    private static final long serialVersionUID = -5881394110154343005L;

    public UserLogin()
    {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String user_id = request.getParameter("user_id");
        String user_pwd = request.getParameter("user_pwd");

        int count = UserFunction.selectByLogin(user_id, user_pwd);

        if(count > 0)
        {
            HttpSession session = request.getSession();
            session.setAttribute("user_id", user_id);
            String tag =findUserTag(user_id);
            session.setAttribute("user_tag", tag);
            request.setAttribute("flag", 0);

            response.sendRedirect("index.jsp");
        }
        else
        {
            request.setAttribute("flag", 1);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
