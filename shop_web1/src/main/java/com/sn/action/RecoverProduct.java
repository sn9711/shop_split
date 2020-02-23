package com.sn.action;

import com.sn.entity.CartItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class RecoverProduct extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String strid = request.getParameter("id");
        Integer id = Integer.valueOf(strid);

        Map<Integer, CartItem> dem = (Map<Integer, CartItem>) session.getAttribute("demap");
        Map<Integer, CartItem> map = null;

        if (session.getAttribute("map") == null) {
            map = new HashMap<Integer, CartItem>();
        } else {
            map = (Map<Integer, CartItem>) session.getAttribute("map");
        }
        map.put(id, dem.get(id));
        session.setAttribute("map", map);
        dem.remove(id);
        session.setAttribute("demap", dem);
        response.sendRedirect(request.getContextPath() + "/ShopCarView.jsp");

    }
}




















