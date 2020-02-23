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
import java.util.Set;


public class UpdateNumAction extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        //�Ϲ��ﳵ����
        HashMap<Integer, CartItem> map = (HashMap<Integer, CartItem>) session.getAttribute("map");

        String[] strids = request.getParameterValues("ids");
        String[] strnums = request.getParameterValues("1");
        //����վ����
        Map<Integer, CartItem> dem = null;
        if (session.getAttribute("demap") == null) {
            dem = new HashMap<Integer, CartItem>();
        } else {
            dem = (Map<Integer, CartItem>) session.getAttribute("demap");
        }
        //�½����ﳵ����
        Map<Integer, CartItem> m = new HashMap<Integer, CartItem>();

        if (strids == null) {//ȫɾ���ﳵ��Ʒ
            Set<Integer> set = map.keySet();
            for (Integer i : set) {
                dem.put(i, map.get(i));
            }
            session.removeAttribute("map");
            session.setAttribute("demap", dem);
        } else {

            //ɾ�����ֹ��ﳵ��Ʒ
            for (int i = 0; i < strids.length; i++) {
                Integer id = Integer.valueOf(strids[i]);
                Integer num = Integer.valueOf(strnums[i]);
                CartItem car = map.get(id);
                car.setNum(num);
                m.put(id, car);
                map.remove(id);
            }
            //�Ϲ��ﳵ��ɾ����Ҫ����Ʒ��ӵ�����վ������
            Set<Integer> set = map.keySet();
            for (Integer id : set) {
                dem.put(id, map.get(id));
            }
        }

        session.setAttribute("map", m);
        session.setAttribute("demap", dem);

        response.sendRedirect(request.getContextPath() + "/ShopCarView.jsp");

    }
}















