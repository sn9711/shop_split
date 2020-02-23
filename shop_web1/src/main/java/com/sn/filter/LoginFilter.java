package com.sn.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession();
        Object obj = session.getAttribute("use");

        if (obj != null) {
            chain.doFilter(req, resp);
        } else {
            response.sendRedirect(request.getContextPath() + "/LoginView.jsp");
        }

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}
