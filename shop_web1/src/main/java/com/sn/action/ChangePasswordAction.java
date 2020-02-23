package com.sn.action;

import com.sn.entity.User;
import com.sn.service.UserService;
import com.sn.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ChangePasswordAction extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User use = (User) request.getSession().getAttribute("use");
        String username = use.getUsername();
        String oldPass = request.getParameter("oldPass");
        String newPass = request.getParameter("newPass1");

        UserService us = new UserServiceImpl();
        us.updatePassword(username, oldPass, newPass);
        request.getSession().setAttribute("use", us.login(username, newPass));

        response.sendRedirect(request.getContextPath() + "/ChangePasswordSuccess.jsp");

    }
}













