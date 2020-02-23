package com.sn.action;

import com.sn.entity.CartItem;
import com.sn.entity.Product;
import com.sn.service.ProductService;
import com.sn.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;


public class AddCarAction extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("map") == null) {
            session.setAttribute("map", new HashMap<Integer, CartItem>());
        }
        HashMap<Integer, CartItem> map = (HashMap<Integer, CartItem>) session.getAttribute("map");

        String strid = request.getParameter("id");
        Integer id = Integer.valueOf(strid);
        ProductService ps = new ProductServiceImpl();
        Product pro = ps.queryByid(id);
        Set<Integer> set = map.keySet();

        if (set.contains(id)) {
            Integer num = map.get(id).getNum();
            CartItem car = new CartItem(pro.getId(), pro.getProductName(), pro.getPicpath(), pro.getPrice(), num + 1);
            map.put(id, car);
            session.setAttribute("map", map);
            session.setAttribute("pro", pro);
        } else {
            CartItem car = new CartItem(pro.getId(), pro.getProductName(), pro.getPicpath(), pro.getPrice(), 1);
            map.put(id, car);
            session.setAttribute("map", map);
            session.setAttribute("pro", pro);
        }

        response.sendRedirect(request.getContextPath() + "/AddCarSuccess.jsp");

    }
}











