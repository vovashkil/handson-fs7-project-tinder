package com.tinder.filters;

import com.tinder.servlets.LoginServlet;
import com.tinder.utils.Params;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterServletPostLogin implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        if (httpRequest.getMethod().equalsIgnoreCase("POST")
                && !new Params(httpRequest).containsAll(LoginServlet.f_lg, LoginServlet.f_pw)) {
            ((HttpServletResponse)servletResponse).sendRedirect("/login");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
