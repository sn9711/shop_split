package com.sn.action;

import com.sn.entity.User;
import com.sn.service.UserService;
import com.sn.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginAction extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();


        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserService us = new UserServiceImpl();
        User use = us.login(username, password);


        if (use != null) {
            session.setAttribute("use", use);
            response.sendRedirect(request.getContextPath() + "/QueryProductAction");
        } else {
            response.sendRedirect(request.getContextPath() + "/LoginView.jsp?errorMsg=username or password is error!!!");
        }

    }
}
