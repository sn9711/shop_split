package com.sn.action;

import com.sn.entity.User;
import com.sn.service.UserService;
import com.sn.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CreateUser extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("pass1");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String strzip = request.getParameter("zip");
        Integer zip = Integer.valueOf(strzip);

        UserService us = new UserServiceImpl();
        User use = new User(username, password, name, zip, address);
        us.insert(use);

        response.sendRedirect(request.getContextPath() + "/LoginView.jsp");

    }

}






















