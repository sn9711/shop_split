package com.sn.action;

import com.sn.entity.User;
import com.sn.service.UserService;
import com.sn.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ChangeUserMessageAction extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String strzip = request.getParameter("zip");
        Integer zip = Integer.valueOf(strzip);
        String address = request.getParameter("address");
        User use = new User(username, password, name, zip, address);
        UserService us = new UserServiceImpl();
        us.updateMessage(use);

        response.sendRedirect(request.getContextPath() + "/ChangeUserMessageSuccess.jsp");


    }
}




















