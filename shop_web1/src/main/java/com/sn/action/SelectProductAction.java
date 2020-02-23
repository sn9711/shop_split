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


public class SelectProductAction extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String productName = request.getParameter("productName");
        String opt = request.getParameter("opt");
        String strprice = request.getParameter("price");

        String strpage = request.getParameter("page");
        Integer page = 1;//��ʼ��ʾ��һҳ����
        List<Product> pagepros = null;//ÿһҳ������
        Integer pages = null;//��ǰҳ
        List<Product> pros = null;//��ѯ������

        ProductService ps = new ProductServiceImpl();

        if (strprice == "") {
            //ֻ��������ģ����ѯ
            pros = ps.queryByname(productName);//������
            //������ҳ��
            if (pros.size() % 2 > 0) {
                pages = pros.size() / 2 + 1;
            } else {
                pages = pros.size() / 2;
            }
            if (strpage == null) {//��ʾ��һҳ
                pagepros = ps.queryBynameAndpage(productName, page);
            } else {//��ʾ��ת��ҳ��
                page = Integer.valueOf(strpage);
                pagepros = ps.queryBynameAndpage(productName, page);
            }

        } else {
            Integer i = Integer.valueOf(opt);
            Double price = Double.valueOf(strprice);
            if (i == 1) {
                //����С�ڲ�ѯ��������
                pros = ps.queryByname1(productName, price);
                //������ҳ��
                if (pros.size() % 2 > 0) {
                    pages = pros.size() / 2 + 1;
                } else {
                    pages = pros.size() / 2;
                }
                if (strpage == null) {//��ʾ��һҳ
                    pagepros = ps.queryByname1Andpage(productName, price, page);
                } else {//��ʾ��ת��ҳ��
                    page = Integer.valueOf(strpage);
                    pagepros = ps.queryByname1Andpage(productName, price, page);
                }

            } else {
                //���ִ��ڲ�ѯ��������
                pros = ps.queryByname2(productName, price);
                //������ҳ��
                if (pros.size() % 2 > 0) {
                    pages = pros.size() / 2 + 1;
                } else {
                    pages = pros.size() / 2;
                }
                if (strpage == null) {//��ʾ��һҳ
                    pagepros = ps.queryByname2Andpage(productName, price, page);
                } else {//��ʾ��ת��ҳ��
                    page = Integer.valueOf(strpage);
                    pagepros = ps.queryByname2Andpage(productName, price, page);
                }

            }
        }

        request.setAttribute("productName", productName);
        request.setAttribute("opt", opt);
        request.setAttribute("strprice", strprice);
        request.setAttribute("page", page);
        request.setAttribute("pages", pages);
        request.setAttribute("pagepros", pagepros);
        request.getRequestDispatcher("/SelectProductView.jsp").forward(request, response);

    }
}



















