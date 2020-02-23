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


public class DeleteOneAction extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String strid = request.getParameter("id");
        Integer id = Integer.valueOf(strid);

        HttpSession session = request.getSession();
        HashMap<Integer, CartItem> map = (HashMap<Integer, CartItem>) session.getAttribute("map");
        //�Ȱ�ɾ���ķŵ�����վmap������
        Map<Integer, CartItem> dem = null;
        if (session.getAttribute("demap") == null) {
            dem = new HashMap<Integer, CartItem>();
        } else {
            dem = (Map<Integer, CartItem>) session.getAttribute("demap");
        }

        dem.put(id, map.get(id));
        session.setAttribute("demap", dem);
        //��ɾ�����ﳵ�����еĶ���
        map.remove(id);
        session.setAttribute("map", map);

        response.sendRedirect(request.getContextPath() + "/ShopCarView.jsp");

    }

}












