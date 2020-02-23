package com.sn.action;

import com.sn.entity.Product;
import com.sn.service.ProductService;
import com.sn.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class QueryProductAction extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String strpage = request.getParameter("page");
        Integer page = 1;
        ProductService ps = new ProductServiceImpl();
        Integer pages = ps.queryAllPage();
        List<Product> pagepros = null;
        if (strpage == null) {
            pagepros = ps.queryBypage(page);
        } else {
            page = Integer.valueOf(strpage);
            pagepros = ps.queryBypage(page);
        }

        request.setAttribute("page", page);
        request.setAttribute("pages", pages);
        request.setAttribute("pagepros", pagepros);
        request.getRequestDispatcher("/QueryProductView.jsp").forward(request, response);

    }

}




















